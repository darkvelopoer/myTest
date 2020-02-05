package com.yyh.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CountTest {
	public static void main(String args[]) throws IOException {
        try {

            File f = new File("D:/Dev2019/workspace/projTest/src/com/yyh/practice/data");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("Reading file using Buffered Reader");

            StringBuilder sb = new StringBuilder();
            while ((readLine = b.readLine()) != null) {
                System.out.println(readLine);
                sb.append(readLine);
            }
            
            char[] stringChar = sb.toString().toCharArray();
            
            
            

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
}
