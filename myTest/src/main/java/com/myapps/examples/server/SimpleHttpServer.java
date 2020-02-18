package com.myapps.examples.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.myapps.examples.processor.WriteProcessor;


public class SimpleHttpServer implements Runnable{

	private Socket socket;
	public SimpleHttpServer(Socket socket) {
		this.socket = socket;
	}
	
	
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8118);
		System.out.println("Listening");
		while(true) {
			/*final Socket clientSocket = server.accept();
			InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());	
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			while(line !=null && !line.isEmpty()) {
				System.out.println(line);
				line = br.readLine();
			}*/
			SimpleHttpServer httpServer = new SimpleHttpServer(server.accept());
			Thread thread = new Thread(httpServer);
			thread.run();
			
			//try (Socket socket = server.accept()) {
				
			//}
		}
	}




	@Override
	public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(socket.getInputStream());

			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			int contLgt = 0;
			String actionType = "";
			if(line !=null) {
				boolean isPost = line.startsWith("POST");
				System.out.println("isPost: " + isPost);
				while(!line.isEmpty()) {
					System.out.println(line);
					
					line = br.readLine();
					
					if(line.indexOf("actionType") > -1) {
						actionType = line.substring(line.indexOf("actionType:") + 12,line.length());
					}
					if (line.indexOf("Content-Length:") > -1) {
						 String sus = line.substring(line.indexOf("Content-Length:") + 16,line.length());
						 //System.out.println("s>>" + sus);
						 contLgt = new Integer(sus).intValue();
	
						 //System.out.println(">>" + contLgt);
						 /*if(contLgt>1) {
							 char[] charArray = new char[contLgt];
							 br.read(charArray, 0 , contLgt);
							 String postData = new String(charArray);
							 System.out.println("postData>>" + postData);
							 System.out.println("----------");
						 }*/
					 }
					//System.out.println("-" + line);
				}
				//StringBuilder body = new StringBuilder();
			    if (isPost && contLgt > 0) {
			    //int c = 0;
			        char[] charArray = new char[contLgt];
			        br.read(charArray, 0 , contLgt);
			        String postData = new String(charArray);
			        System.out.println("postData>>" + postData);
			        
			        WriteProcessor processor = new WriteProcessor();
			        processor.processData(postData, actionType);
			        
			        //JsonObject jsonObject = new JsonParser().parse(postData).getAsJsonObject();
			        //String prodId = jsonObject.get("productId").getAsString();
			        //System.out.println("prodId: " + prodId);
			        
			        /*for (int i = 0; i < contLgt; i++) {
			            c = br.read();
			            body.append((char) c);
			            //System.out.println("JCD", "POST: " + ((char) c) + " " + c);
			        }*/
			    }
			}
			else {
				System.out.println("none here");
			}
			
			//Date today = new Date(); 
			LocalDate localDate = LocalDate.now();
			LocalTime localTime = LocalTime.now();  
			String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + localDate.toString() + localTime.toString(); 
			socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
			System.out.println("end receive ");
			socket.close();
	
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
