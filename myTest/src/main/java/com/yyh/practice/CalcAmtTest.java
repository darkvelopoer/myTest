package com.yyh.practice;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcAmtTest {

	
	
    public static BigDecimal calcNetOrdAmt(double rate, String buyAmt){
		BigDecimal orgAmt = new BigDecimal(buyAmt);
		BigDecimal dscAmt = (orgAmt.multiply(new BigDecimal(rate))).divide(new BigDecimal(100));
		return roundDown(orgAmt.subtract(dscAmt),0);
    }
    
    public static BigDecimal roundDown(BigDecimal a, int scale)
    {
        return a.setScale(scale, RoundingMode.DOWN);
    }
}
