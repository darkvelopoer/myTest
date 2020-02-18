package com.yyh.practice;

import java.io.File;
import java.util.Properties;
import java.util.Vector;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import com.yyh.practice.util.CryptoUtil;

/*import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import skt.tmall.common.util.CryptoUtil;*/

public class ChecksumTest {
	public static void main(String args[]){
		//uploadFile();
		//downloadFile();
		
		//checksum();
		
		//TUB
		//checksumMD5("871318BD1DB378CE321BEK63863986C9", "CELCOM", "0123456799", "3000");//yuehong@11street
		
		//checksumMD5("776618BD1DB378CE321TRY6386398766", "CELCOM", "0123456799", "1000"); //krash
		
		//checksumMD5("349318BD1FVIPXJJ321TRY6344391100", "CELCOM", "0132617822", "5000"); //43C555269ADACD725E177C841F7B7D15 quality.assurance@11street.my
		
		//checksumMD5("9018928812", "presto", "01199234555", "runner");--randomstr
		
		//prod
		//checksumMD5("871318BD1DB378CE321BEK63863986C9", "CELCOM", "0132617822", "1000"); //334769DF188675F4180A06FB1086A83B
		//checksumMD5("871318BD1DB378CE321BEK63863986C9", "CELCOM", "0132617822", "3000"); //CFEA8DE2D77A0D8377A3A3A792E39411
		
		//checksumMD5("871318BD1DB378CE321BEK63863986C9", "CELCOM", "0132617822", "10000"); //1374A20B0F1BA3B91B3EECDD2900F75B //1837447761D13C61D35B1F7739370C5D
		
		//--checksumMD5("0617AF3E5643CA3C4FFAED3F1AD08F6E", "CELCOM", "0123456799", "9500"); //tester quality.assurance@11street.my hashkey 
		   //349318BD1FVIPXJJ321TRY6344391100 
					 //69A247A7BA6F3C849A3458D020F60AAC  --tub secretKey
					 //D87DEA658D7B9BFA8FCE7478E5752EBC	 --tub hashKey
		//checksumMD5("TUB11streetapi12122018-hashkey");
		
		
		//test hashkey -- 0617AF3E5643CA3C4FFAED3F1AD08F6E
		//test secretkey -- E043D4B76256B5A652CC286A215DF104
		//checksumMD5("TUBqa11streetapi13122018-hashkey"); 
		//checksumMD5("TUBqa11streetapi13122018-secretkey"); 
		
		//checksum();
		//checksumMD5("0617AF3E5643CA3C4FFAED3F1AD08F6E", "CELCOM", "01120809087", "1000");
	}
	

	
	private static void encFile(String dir){
		//String dir = "C:/Users/CPLT165/Desktop/boost prod check/090419/new/New folder/";//"C:/Users/CPLT165/Desktop/boost prod check/2611/2211upd3/";
		File dirFile = new File(dir);
		for (File file : dirFile.listFiles()) {
			if (file.getName().endsWith((".ack")) ||
					file.getName().endsWith((".setl")) ||
					file.getName().endsWith((".cntl"))) {
				String ackFilePath = dir + file.getName();	
				//Get checksum
				try {
					String ackFileCheckSum = CryptoUtil.getSHA256FileHexHash(ackFilePath);
					System.out.println("Filename:" + file.getName());
					System.out.println("CKS:" + ackFileCheckSum);
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
			
		}
	}
	
}