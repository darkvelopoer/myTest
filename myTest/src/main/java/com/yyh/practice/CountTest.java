package com.yyh.practice;


import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CountTest {
	public static void main(String args[]) throws IOException {
		System.out.println("test");

        int buyAmt = 190000;
        double rate = 2.3;
        BigDecimal orgAmt = new BigDecimal(buyAmt);
        BigDecimal dscAmt = (orgAmt.multiply(new BigDecimal(rate))).divide(new BigDecimal(100));

        System.out.println("Result: " + dscAmt.setScale(4, RoundingMode.DOWN));
	}
	
	
}
