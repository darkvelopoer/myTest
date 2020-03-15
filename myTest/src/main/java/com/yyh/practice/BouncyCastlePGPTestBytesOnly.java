package com.yyh.practice;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Date;
import java.util.Iterator;

import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedData;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataList;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPLiteralDataGenerator;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyEncryptedData;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.bc.BcPBESecretKeyDecryptorBuilder;
import org.bouncycastle.openpgp.operator.bc.BcPGPDigestCalculatorProvider;
import org.bouncycastle.openpgp.operator.bc.BcPublicKeyDataDecryptorFactory;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcePGPDataEncryptorBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePublicKeyKeyEncryptionMethodGenerator;

public class BouncyCastlePGPTestBytesOnly {


/*   private static PGPPrivateKey findSecretKey(
            PGPSecretKeyRingCollection pgpSec, long keyID, char[] pass)
            throws PGPException, NoSuchProviderException {
        PGPSecretKey pgpSecKey = pgpSec.getSecretKey(keyID);

        if (pgpSecKey == null) {
            return null;
        }
        return pgpSecKey.extractPrivateKey(new BcPBESecretKeyDecryptorBuilder(new BcPGPDigestCalculatorProvider()).build(pass));
        //return pgpSecKey.extractPrivateKey(pass, "BC");
    }*/
    
    public static PGPSecretKey readSecretKeyFromCol(InputStream in, long keyId) throws IOException, PGPException {
        in = PGPUtil.getDecoderStream(in);
        PGPSecretKeyRingCollection pgpSec = new PGPSecretKeyRingCollection(in, new BcKeyFingerprintCalculator());

        PGPSecretKey key = pgpSec.getSecretKey(keyId);

        if (key == null) {
            throw new IllegalArgumentException("Can't find encryption key in key ring.");
        }
        return key;
    }
    
    /*public static PGPPublicKey readPublicKeyFromCol(InputStream in) throws IOException, PGPException {
        in = PGPUtil.getDecoderStream(in);
        PGPPublicKeyRingCollection pgpPub = new PGPPublicKeyRingCollection(in, new BcKeyFingerprintCalculator());
        PGPPublicKey key = null;
        Iterator rIt = pgpPub.getKeyRings();
        while (key == null && rIt.hasNext()) {
            PGPPublicKeyRing kRing = (PGPPublicKeyRing) rIt.next();
            Iterator kIt = kRing.getPublicKeys();
            while (key == null && kIt.hasNext()) {
                PGPPublicKey k = (PGPPublicKey) kIt.next();
                if (k.isEncryptionKey()) {
                    key = k;
                }
            }
        }
        if (key == null) {
            throw new IllegalArgumentException("Can't find encryption key in key ring.");
        }
        return key;
    }*/

    /**
     * decrypt the passed in message stream
     * 
     * @param encrypted
     *            The message to be decrypted.
     * @param passPhrase
     *            Pass phrase (key)
     * 
     * @return Clear text as a byte array. I18N considerations are not handled
     *         by this routine
     * @exception IOException
     * @exception PGPException
     * @exception NoSuchProviderException
     */
    @SuppressWarnings("resource")
	public static byte[] decryptPgp(byte[] encrypted, InputStream secretKeyInputStream, char[] password)
            throws IOException, PGPException, NoSuchProviderException {
        InputStream encryptedInputStream = new ByteArrayInputStream(encrypted);
        encryptedInputStream = PGPUtil.getDecoderStream(encryptedInputStream);
        PGPObjectFactory pgpFactory = new PGPObjectFactory(encryptedInputStream, null);

        PGPEncryptedDataList enc = null;
        Object obj = pgpFactory.nextObject();

        // The first object might be a PGP marker packet.
        if (obj instanceof PGPEncryptedDataList) {
            enc = (PGPEncryptedDataList) obj;
        } else {
            enc = (PGPEncryptedDataList) pgpFactory.nextObject();
        }

        PGPSecretKey secretKey = null;
        // Find the secret key
        Iterator<PGPPublicKeyEncryptedData> it = enc.getEncryptedDataObjects();
        PGPPrivateKey privateKey = null;
        PGPPublicKeyEncryptedData publicKeyEncryptedData = null;
        
        while (privateKey == null && it.hasNext()) {
        	publicKeyEncryptedData = it.next();
        	secretKey = readSecretKeyFromCol(secretKeyInputStream, publicKeyEncryptedData.getKeyID()); 
            privateKey = secretKey.extractPrivateKey(new BcPBESecretKeyDecryptorBuilder(new BcPGPDigestCalculatorProvider()).build(password));
        }

        if (secretKey == null) {
            throw new IllegalArgumentException("Secret key not found.");
        }
        else if (privateKey == null) {
            throw new IllegalArgumentException("Private key not found.");
        }

        InputStream clear = publicKeyEncryptedData.getDataStream(new BcPublicKeyDataDecryptorFactory(privateKey)); 
        PGPObjectFactory pgpFact = new PGPObjectFactory(clear, null);
        PGPCompressedData cData = (PGPCompressedData) pgpFact.nextObject();
        pgpFact = new PGPObjectFactory(cData.getDataStream(), null);
        PGPLiteralData literalData = (PGPLiteralData) pgpFact.nextObject();
        InputStream unc = literalData.getInputStream();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int ch;
        while ((ch = unc.read()) >= 0) {
            out.write(ch);
        }

        byte[] returnBytes = out.toByteArray();
        
        out.close();
        unc.close();
        clear.close();
        secretKeyInputStream.close();
        encryptedInputStream.close();
        return returnBytes;
    }

    /**
     * Simple PGP encryptor between byte[].
     * 
     * @param clearData
     *            The test to be encrypted
     * @param passPhrase
     *            The pass phrase (key). This method assumes that the key is a
     *            simple pass phrase, and does not yet support RSA or more
     *            sophisiticated keying.
     * @param fileName
     *            File name. This is used in the Literal Data Packet (tag 11)
     *            which is really inly important if the data is to be related to
     *            a file to be recovered later. Because this routine does not
     *            know the source of the information, the caller can set
     *            something here for file name use that will be carried. If this
     *            routine is being used to encrypt SOAP MIME bodies, for
     *            example, use the file name from the MIME type, if applicable.
     *            Or anything else appropriate.
     * 
     * @param armor
     * 
     * @return encrypted data.
     * @exception IOException
     * @exception PGPException
     * @exception NoSuchProviderException
     */
    public static byte[] encryptPgp(byte[] clearData, PGPPublicKey encKey,
            String fileName,boolean withIntegrityCheck, boolean armor)
            throws IOException, PGPException, NoSuchProviderException {
        if (fileName == null) {
            fileName = PGPLiteralData.CONSOLE;
        }

        ByteArrayOutputStream encOut = new ByteArrayOutputStream();

        OutputStream out = encOut;
        if (armor) {
            out = new ArmoredOutputStream(out);
        }

        ByteArrayOutputStream bOut = new ByteArrayOutputStream();

        PGPCompressedDataGenerator comData = new PGPCompressedDataGenerator(
                PGPCompressedDataGenerator.ZIP);
        OutputStream cos = comData.open(bOut); // open it with the final
        // destination
        PGPLiteralDataGenerator lData = new PGPLiteralDataGenerator();

        // we want to generate compressed data. This might be a user option
        // later,
        // in which case we would pass in bOut.
        OutputStream pOut = lData.open(cos, // the compressed output stream
                PGPLiteralData.BINARY, fileName, // "filename" to store
                clearData.length, // length of clear data
                new Date() // current time
                );
        pOut.write(clearData);
        
        pOut.close();
        lData.close();
        comData.close();

       // PGPEncryptedDataGenerator cPk = new PGPEncryptedDataGenerator(
        //        PGPEncryptedData.CAST5, withIntegrityCheck, new SecureRandom(),
         //       "BC");

        //cPk.addMethod(encKey);
        
	    PGPEncryptedDataGenerator cPk = new PGPEncryptedDataGenerator(new JcePGPDataEncryptorBuilder(SymmetricKeyAlgorithmTags.AES_256) //.CAST5
	            .setSecureRandom(new SecureRandom()).setProvider("BC"));
	    cPk.addMethod(new JcePublicKeyKeyEncryptionMethodGenerator(encKey));

        byte[] bytes = bOut.toByteArray();

        OutputStream cOut = cPk.open(out, bytes.length);
        cOut.write(bytes); // obtain the actual bytes from the compressed stream
        cOut.close();
        out.close();
        return encOut.toByteArray();
    }

    
    private static PGPPublicKey readPublicKey(InputStream in) throws IOException {
        try {
            //PGPPublicKeyRing pgpPub = new PGPPublicKeyRing(in, new JcaKeyFingerprintCalculator());
            PGPPublicKeyRing pgpPub = new
            		PGPPublicKeyRing(PGPUtil.getDecoderStream(in), new JcaKeyFingerprintCalculator());
            //PGPPublicKeyRing pgpPub = new PGPPublicKeyRing(in);
            return pgpPub.getPublicKey();
        } catch (IOException io) {
            System.out.println("readPublicKey() threw an IOException");
            System.out.println(io.toString());
            throw io;
        }

    }

    public static byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        // Get the size of the file
        long length = file.length();

        if (length > Integer.MAX_VALUE) {
            // File is too large
        	throw new IOException("File is too large");
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
               && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;
    }

    public static String encryptToFilePgp(String inputStr, String pubKeyFile, String outFile) throws Exception { //
        Security.addProvider(new BouncyCastleProvider());
        byte[] original = inputStr.getBytes();
        FileInputStream pubKey = new FileInputStream(pubKeyFile);
        byte[] encrypted = encryptPgp(original, readPublicKey(pubKey), null,
                true, true);
        FileOutputStream dfis = new FileOutputStream(outFile);
        dfis.write(encrypted);
        dfis.close();

        return new String(encrypted);
    }
    
    public static String encryptToBytesPgp(String inputStrToEncrypt, String pubKeyFile) throws Exception { 
        Security.addProvider(new BouncyCastleProvider());
        byte[] original = inputStrToEncrypt.getBytes();
        FileInputStream pubKey = new FileInputStream(pubKeyFile);
        byte[] encrypted = encryptPgp(original, readPublicKey(pubKey), null, true, true);

        return new String(encrypted);
    }

    public static String decryptFromFilePgp(String passphrase, String secKeyFile, String encryptedFile) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        byte[] encFromFile = getBytesFromFile(new File(encryptedFile));
        FileInputStream secKey = new FileInputStream(secKeyFile);
        //FileInputStream pubKey = new FileInputStream(pubKeyFile);
        byte[] decrypted = decryptPgp(encFromFile, secKey, passphrase.toCharArray());

        return new String(decrypted);
    }
    
    public static String decryptFromBytesPgp(String passphrase, String secKeyFile, String encryptedString) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        byte[] encFromBytes = encryptedString.getBytes();
        FileInputStream secKey = new FileInputStream(secKeyFile);
        byte[] decrypted = decryptPgp(encFromBytes, secKey, passphrase.toCharArray());

        return new String(decrypted);
    }

    public static void main(String[] args) throws Exception {
        //String encrypted = encryptToFile("the message I want to encrypt", "files//0x3183541F-pub.asc", "files//enc-file.asc"); //, "files//enc-file.asc" ("Hello world","pub.asc","enc.asc");
        //System.out.println("\nencrypted data = '" + new String(encrypted) + "'");

        //String decrypted = decryptFromFile("prestomall", "files//0x3183541F-sec.asc", "files//enc-file.asc"); //("open sesame", "secret.asc", "enc.asc");
        //System.out.println("\ndecrypted data = '" + decrypted + "'");

        String encrypted = encryptToBytesPgp("Please encrypt this message", "files//0x3183541F-pub.asc"); //, "files//enc-file.asc" ("Hello world","pub.asc","enc.asc");
        System.out.println("\nencrypted data = \n'" + new String(encrypted) + "'");
        String decrypted = decryptFromBytesPgp("prestomall", "files//0x3183541F-sec.asc", encrypted); 
        System.out.println("\ndecrypted data = \n'" + decrypted + "'");
    }
}
