package com.yyh.practice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

//import com.skt.omp.common.util.DataBox;

//import oracle.sql.DATE;
//import skt.tmall.common.escrow.ApiTopupConstDef;

//import java.util.Properties;

//import org.apache.commons.lang3.StringUtils;
/*
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;*/

//import skt.tmall.common.escrow.BoostConstDef;

public class FtpTest {
	public static void main(String args[]) {
		//uploadFile();
		//downloadFile();
		
		//orderlogistic.jsp tesco loop
		int x = 1;
		for(int i=1; i <= 23; i++){
			if(i==1){
				System.out.println("12:00:00 AM - 12:00 AM");
				System.out.println("12:30:00 AM - 12:30 AM");
			}
			if(i<=11){
				if(i==9){
					System.out.println("0" + i + ":00:00 AM - selected " + "0" + i + ":00 AM");
				}
				else{
					if(i<=9){
						System.out.println("0" + i + ":00:00 AM - " + "0" + i + ":00 AM");
					}
					else{
						System.out.println(i + ":00:00 AM - " + i + ":00 AM");
					}
				}
				
				if(i<=9){
					System.out.println("0" + i + ":30:00 AM - " + "0" + i + ":30 AM");
				}
				else{
					System.out.println(i + ":30:00 AM - " + i + ":30 AM");
				}
			}
			else if(i==12){
				System.out.println(i + ":00:00 PM - " + i + ":00 PM");
				System.out.println(i + ":30:00 PM - " + i + ":30 PM");
			}
			else{
				if(i<=21){
					System.out.println("0" + x + ":00:00 PM - " + "0" + x + ":00 PM");
				}
				else{
					System.out.println(x + ":00:00 PM -" + x + ":00 PM");
				}
				
				if(i<=21){
					System.out.println("0" + x + ":30:00 PM - " + "0" + x + ":30 PM");
				}
				else{
					System.out.println(x + ":30:00 PM -" + x + ":30 PM");
				}
				x++;
			}
		}
		
		//String addr = "PopBox @ Uniten,Admin Building - Lobby Pengurusan [Students & Staffs], Jalan Ikram-Uniten, 43000 Kaj";
		//String ad = addr.substring(0, addr.indexOf(","));
		//System.out.println(">>>" + ad);
		
		
		
		//System.out.println(":" + calcNetOrdAmt(5.5, "6500"));
		
		//System.out.println("Is aaa palindrom?: " + isPalindromString("aaa")); 
		//System.out.println("Is abc palindrom?: " + isPalindromString("abc"));
		//Map<String, String> mp = new HashMap<String, String>() ;
		//System.out.println("==" + mp.get("tst"));
		 //TimeZone tz = TimeZone.getTimeZone("UTC");
		/*String createdAtMin = "2018-09-19T06:23:00+08:00"; // "2018-09-19T06:23:00+0800";
		DateFormat formater = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); //ApiTopupConstDef.ISO8601_TS_FORMAT //yyyy-MM-dd'T'HH:mm:ssZ
		//formater.setTimeZone(TimeZone.getTimeZone("UTC"));
		try {
			
			Date dv = formater.parse(createdAtMin);
			System.out.println("start: " + dv);
			
			DateFormat formateD = new SimpleDateFormat("yyyyMMddHHmmss");
			System.out.println(">>>" + formateD.format(dv));
			
			Date dt = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");
			System.out.println("aaa: " +df.format(dt));
			
			
			DateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"); 
			System.out.println("ed: " +formater2.format(dt));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//System.out.println("start: " + format.parse(createdAtMax));
		
		//DataBox dt = new DataBox();
		//System.out.println(">> " + dt.get("tt"));
/*		String orgAmount = "10000";
		String rate = "5.5";
		BigDecimal orgAmt = new BigDecimal(orgAmount);
		BigDecimal dscAmt = (orgAmt.multiply(new BigDecimal(rate))).divide(new BigDecimal(100));
		BigDecimal netOrdAmt = orgAmt.subtract(dscAmt);
		
		System.out.println("netOrdAmt: " + netOrdAmt);*/
		
/*		String ISO8601Long = "yyyy-MM-dd'T'HH:mm:ssZ";
		Date currDt = new Date();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(ISO8601Long);
		//dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		String newf = new SimpleDateFormat(ISO8601Long).format(currDt);
		System.out.println("DateL: " + newf);*/
/*		try {
			Date newDate = dateFormat.parse(currDt);
			System.out.println("DateL: " + newDate.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		

/*		String test = removeSeparatorCharacters("My|test|ok");
		System.out.println(test);
		
		String test2 = "ok|me|go";
		String[] test3 = test2.split("\\|");
		for(String str : test3){
			System.out.println(str);
		}*/
		/*try {
			JSch sshClient = new JSch();
			System.out.println("start 0");
			sshClient.addIdentity("D:/data1/id_rsa", "qhdks!");
			System.out.println("start 1");
			Session session = sshClient.getSession("elevenstreet", "ads.qredit.myboost.id", 22);
			System.out.println("start 2");
			//session.setConfig("StrictHostKeyChecking", "no"); 
			//session.setConfig("kex", "diffie-hellman-group1-sha1"); 
			//session.setConfig("kex", "diffie-hellman-group-exchange-sha1,diffie-hellman-group14-sha1,diffie-hellman-group1-sha1");

			// only for password authentication
			//session.setPassword("qhdks!");
			System.out.println("start 21");

			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");

			session.setConfig(config);
			session.setTimeout(5000);
			session.connect();
			
			
			System.out.println("start 3");
			//ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
			System.out.println("start 4");
			sftpChannel.connect();
			System.out.println("start 5");
			sftpChannel.put("D:/data1/bk/setest.setl", "/INBOX/file.zip");
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //catch (SftpException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
*/	}
	

	

    

	private static void downloadFile(){
		/*Session session = null; 
		ChannelSftp channel = null;
		try{
			String privateKey = "D:\\data1\\id_rsa";
			String user = "elevenstreet";
			String host = "ads.qredit.myboost.id";
			Integer port = 22;
	
			JSch jsch = new JSch();
			jsch.addIdentity(privateKey, "qhdks!");
	
			session = jsch.getSession(user, host, port);
	
	
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
	
			session.setConfig(config);
			session.setTimeout(5000);
			session.connect();
	
			channel = (ChannelSftp) session.openChannel("sftp");
			channel.connect();
			Vector<ChannelSftp.LsEntry> remoteOutboxList = channel.ls("/OUTBOX/");
			//remoteOutboxList.addAll(channel.ls("*.setl"));
			//remoteOutboxList.addAll(channel.ls("*.cntl"));
			//BoostConstDef.BOOST_SETTLEMENT_11ST_OUTBOX
			//BOOST_SETTLEMENT_11ST_OUTBOX
			//BOOST_SETTLEMENT_11ST_OUTBOX_ARCHIVE
			if (remoteOutboxList.isEmpty()) {
                System.out.println("No file exist in the specified sftp folder location.");
            }
			else{
				for (ChannelSftp.LsEntry entry : remoteOutboxList) {
	                if(entry.getFilename().contains(".setl") || entry.getFilename().contains(".ack")){
	                	System.out.println("FileName: " + entry.getFilename());
	                	
	                	//try {
	                        // Downloading the file from sftp to the folder path
	                    	channel.get("/OUTBOX/" + entry.getFilename(), "D:/data1/axiata/OUTBOX/" + entry.getFilename());
	                    //} catch (SftpException sftpException) {
	                    	
	                     //   System.out.println(sftpException.getMessage());//("Failed to download the file the sftp folder location.");                    
	                    //}  
	                }
	            }
			}
		}
		catch (JSchException e) {
			//send sms
			//log.error(e.getMessage());
			System.out.println(e.getMessage());
		}
		catch (SftpException e) {
			//send sms
			//log.error(e.getMessage());
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
	        if(channel != null && channel.isConnected()) 
	        	channel.disconnect();
	        if(session != null && session.isConnected()) 
	        	session.disconnect();
	    }*/
	}
	
	private static void uploadFile(){
		/*try{
			String privateKey = "D:\\data1\\id_rsa";
			String user = "elevenstreet";
			String host = "ads.qredit.myboost.id";
			Integer port = 22;

			JSch jsch = new JSch();
			jsch.addIdentity(privateKey, "qhdks!");

			Session session = jsch.getSession(user, host, port);


			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");

			session.setConfig(config);
			session.setTimeout(5000);
			session.connect();

			ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
			channel.connect();
			channel.ls("/");

			channel.put("D:\\data1\\20180612000001.setl", "/INBOX/20180612000001.setl");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}*/
	}
}
