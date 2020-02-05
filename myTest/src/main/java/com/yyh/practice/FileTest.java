package com.yyh.practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import sun.misc.BASE64Encoder;

public class FileTest {
	public static void main(String args[]) throws IOException {
		File file = new File("D:\\tmp\\wcjson.txt");  // assume args[0] is the path to file
        byte[] data = FileUtils.readFileToByteArray(file);
        String enc = (new BASE64Encoder()).encode(data);
		System.out.println(enc);
		
		//ew0KICAiYWRkcmVzc0xpbmUxIjogImd1Z3VzYW4gbWVsdXIiLA0KICAgICJjaXR5IjogInBldGFs
		//aW5nIGpheWEiLA0KICAgICJjb3VudHJ5IjogIm1hbGF5c2lhLiIsDQogICAgImNvdW50cnlDb2Rl
		//IjogIjYwIiwNCiAgICAibmFtZSI6ICJ5dXNzdWYiLA0KICAgICJwaG9uZU51bWJlciI6ICIxNzY0
		//NzMyOTgiLA0KICAgICJwb3N0Q29kZSI6ICI0NzgxMCIsDQogICAgInN0YXRlIjogInNlbGFuZ29y
		//Ig0KfQ==

	}
}
