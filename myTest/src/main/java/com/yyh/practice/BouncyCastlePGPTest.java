package com.yyh.practice;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPLiteralDataGenerator;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcePGPDataEncryptorBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePublicKeyKeyEncryptionMethodGenerator;


public class BouncyCastlePGPTest {

    public static void main(String[] args) {

        // the keyring that holds the public key we're encrypting with
        String publicKeyFilePath = "files//0x3183541F-pub.asc"; //"files//0x3183541F-sec.asc"; // //"C:\\pgp6.5.8\\pubring.pkr";

        // init the security provider
        Security.addProvider(new BouncyCastleProvider());

        try {

            System.out.println("Creating a temp file...");

            // create a file and write the string to it
            File outputfile = File.createTempFile("pgp", null);
            FileWriter writer = new FileWriter(outputfile);
            writer.write("the message I want to encrypt".toCharArray());
            writer.close();

            System.out.println("Temp file created at ");
            System.out.println(outputfile.getAbsolutePath());
            System.out.println("Reading the temp file to make sure that the bits were written\n----------------------------");

            BufferedReader isr = new BufferedReader(new FileReader(outputfile));
            String line = "";
            while ((line = isr.readLine()) != null) {
                System.out.println(line + "\n");
            }

            // read the key 
            FileInputStream in = new FileInputStream(publicKeyFilePath);
            PGPPublicKey key = readPublicKey(in);

            // find out a little about the keys in the public key ring
            System.out.println("Key Strength = " + key.getBitStrength());
            System.out.println("Algorithm = " + key.getAlgorithm());

            int count = 0;
            for (java.util.Iterator iterator = key.getUserIDs(); iterator.hasNext();) {
                count++;
                System.out.println((String)iterator.next());    
            }
            System.out.println("Key Count = " + count);
            // create an armored ascii file
            FileOutputStream out = new FileOutputStream(outputfile.getAbsolutePath() + ".asc");

            // encrypt the file
            encryptFile(outputfile.getAbsolutePath(), out, key);

            System.out.println("Reading the encrypted file\n----------------------------");
            BufferedReader isr2 = new BufferedReader(new FileReader(new File(outputfile.getAbsolutePath() + ".asc")));
            String line2 = "";
            while ((line2 = isr2.readLine()) != null) {
                System.out.println(line2);
            }



        } catch (PGPException e) {
            System.out.println(e.toString());
            System.out.println(e.getUnderlyingException().toString());

        } catch (Exception e) {
            System.out.println(e.toString());
        }

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

    /*private static void encryptFile2(String fileName, OutputStream out, PGPPublicKey encKey)
    throws IOException, NoSuchProviderException, PGPException  
    {

        out = new ArmoredOutputStream(out);

        ByteArrayOutputStream bOut = new ByteArrayOutputStream();

        System.out.println("creating comData...");

        // get the data from the original file 
        PGPCompressedDataGenerator comData = new PGPCompressedDataGenerator(PGPCompressedDataGenerator.ZIP);
        PGPUtil.writeFileToLiteralData(comData.open(bOut), PGPLiteralData.BINARY, new File(fileName));
        comData.close();

        System.out.println("comData created...");

        System.out.println("using PGPEncryptedDataGenerator...");

        // object that encrypts the data
        PGPEncryptedDataGenerator cPk = new PGPEncryptedDataGenerator(PGPEncryptedDataGenerator.CAST5, new SecureRandom(), "BC");
        cPk.addMethod(encKey);

        System.out.println("used PGPEncryptedDataGenerator...");

        // take the outputstream of the original file and turn it into a byte array
        byte[] bytes = bOut.toByteArray();

        System.out.println("wrote bOut to byte array...");

        // write the plain text bytes to the armored outputstream
        OutputStream cOut = cPk.open(out, bytes.length);
        cOut.write(bytes);


        // cOut.close();
        cPk.close();
        out.close();


    }*/

    private static void encryptFile(String fileName, OutputStream out, PGPPublicKey encKey)
    		throws IOException, NoSuchProviderException, PGPException  
    		{

    		    out = new ArmoredOutputStream(out);

    		    ByteArrayOutputStream bOut = new ByteArrayOutputStream();

    		    System.out.println("creating comData...");

    		    // get the data from the original file 
    		    PGPCompressedDataGenerator comData = new PGPCompressedDataGenerator(PGPCompressedDataGenerator.ZIP);
    		    PGPUtil.writeFileToLiteralData(comData.open(bOut), PGPLiteralData.BINARY, new File(fileName));
    		    
    		    
    		    //PGPUtil.writeFileToLiteralData(bOut, fileType, file, buffer);
    		    comData.close();

    		    System.out.println("comData created...");

    		    System.out.println("using PGPEncryptedDataGenerator...");

    		    // object that encrypts the data
    		    //PGPEncryptedDataGenerator cPk = new PGPEncryptedDataGenerator(PGPEncryptedDataGenerator.CAST5, new SecureRandom(), "BC");
    		    //cPk.addMethod(encKey);
    		    // object that encrypts the data
    		    PGPEncryptedDataGenerator cPk = new PGPEncryptedDataGenerator(new JcePGPDataEncryptorBuilder(SymmetricKeyAlgorithmTags.CAST5)
    		            .setSecureRandom(new SecureRandom()).setProvider("BC"));
    		    cPk.addMethod(new JcePublicKeyKeyEncryptionMethodGenerator(encKey));

    		    System.out.println("used PGPEncryptedDataGenerator...");

    		    // take the outputstream of the original file and turn it into a byte array
    		    byte[] bytes = bOut.toByteArray();

    		    System.out.println("wrote bOut to byte array...");

    		    // write the plain text bytes to the armored outputstream
    		    OutputStream cOut = cPk.open(out, bytes.length);
    		    cOut.write(bytes);


    		    // cOut.close();
    		    cPk.close();
    		    out.close();


    		}
    
    private static void encryptFile3(String fileName, OutputStream out, PGPPublicKey encKey)
    		throws IOException, NoSuchProviderException, PGPException  
    		{

    		    out = new ArmoredOutputStream(out);

    		    ByteArrayOutputStream bOut = new ByteArrayOutputStream();

    		    System.out.println("creating comData...");

    		    // get the data from the original file 
    		    PGPCompressedDataGenerator comData = new PGPCompressedDataGenerator(PGPCompressedDataGenerator.ZIP);
    		    PGPUtil.writeFileToLiteralData(comData.open(bOut), PGPLiteralData.BINARY, new File(fileName));
    		    
    		    //PGPLiteralDataGenerator lData = new PGPLiteralDataGenerator();
    	        //OutputStream pOut = lData.open(out, PGPLiteralData.BINARY, new File(fileName));
    		    
    		    comData.close();

    		    System.out.println("comData created...");

    		    System.out.println("using PGPEncryptedDataGenerator...");

    		    // object that encrypts the data
    		    //PGPEncryptedDataGenerator cPk = new PGPEncryptedDataGenerator(PGPEncryptedDataGenerator.CAST5, new SecureRandom(), "BC");
    		    //cPk.addMethod(encKey);
    		    // object that encrypts the data
    		    PGPEncryptedDataGenerator cPk = new PGPEncryptedDataGenerator(new JcePGPDataEncryptorBuilder(SymmetricKeyAlgorithmTags.CAST5)
    		            .setSecureRandom(new SecureRandom()).setProvider("BC"));
    		    cPk.addMethod(new JcePublicKeyKeyEncryptionMethodGenerator(encKey));

    		    System.out.println("used PGPEncryptedDataGenerator...");

    		    // take the outputstream of the original file and turn it into a byte array
    		    byte[] bytes = bOut.toByteArray();

    		    System.out.println("wrote bOut to byte array...");

    		    // write the plain text bytes to the armored outputstream
    		    OutputStream cOut = cPk.open(out, bytes.length);
    		    cOut.write(bytes);


    		    // cOut.close();
    		    cPk.close();
    		    out.close();


    		}
}
