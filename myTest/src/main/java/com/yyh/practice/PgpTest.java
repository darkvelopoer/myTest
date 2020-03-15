package com.yyh.practice;

import java.io.File;
import java.io.IOException;

import com.yyh.practice.util.PGPFileProcessor;

public class PgpTest {

    private static final String PASSPHRASE = "test";
 
    private static final String DE_INPUT = "files//dec_source.txt";//"src/test/x.pgp";
    private static final String DE_OUTPUT = "files//dec_output.txt";//"src/test/x.txt";
    private static final String DE_KEY_FILE = "files//private_key_wc.pem";//"src/test/secring.skr";
 
    private static final String E_INPUT = "files//source.txt"; //"src/test/x.txt";
    private static final String E_OUTPUT = "files//output.txt"; //"src/test/x.pgp";
    private static final String E_KEY_FILE = "files//public_key_wc.pem"; //"src/test/pubring.pkr";
 
	public static void main(String args[]) throws IOException {
		try {
			//testEncrypt();
			File outputfile = File.createTempFile("pgp", null);
			System.out.println(outputfile.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
    public static void testDecrypt() throws Exception {
        PGPFileProcessor p = new PGPFileProcessor();
        p.setInputFileName(DE_INPUT);
        p.setOutputFileName(DE_OUTPUT);
        p.setPassphrase(PASSPHRASE);
        p.setSecretKeyFileName(DE_KEY_FILE);
        System.out.println(p.decrypt());
    }
 
    public static void testEncrypt() throws Exception {
        PGPFileProcessor p = new PGPFileProcessor();
        p.setInputFileName(E_INPUT);
        p.setOutputFileName(E_OUTPUT);
        p.setPassphrase(PASSPHRASE);
        p.setPublicKeyFileName(E_KEY_FILE);
        System.out.println(p.encrypt());
    }
}
