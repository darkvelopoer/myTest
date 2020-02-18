package com.yyh.practice;

import java.util.Properties;

/*import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;*/

public class SftpTest {/*
	public static void main(String args[]) {
		try {
		String privateKey = "D:\\data1\\id_rsa"; //"C:\\Users\\CPLT165\\Downloads\\keys\\id_rsa"; 
		String user = "elevenstreet";
		String host = "ads.qredit.myboost.id";
		Integer port = 22;
		
		JSch jsch = new JSch();
		jsch.addIdentity(privateKey, "qhdks!");

		Session session = jsch.getSession(user, host, port);


		Properties config = new Properties();
		//config.put("kex", "diffie-hellman-group-exchange-sha256");
		config.put("StrictHostKeyChecking", "no");

		session.setConfig(config);
		session.setTimeout(5000);
		System.out.println("start 0");
		session.connect();
		System.out.println("start 1");
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
*/}
