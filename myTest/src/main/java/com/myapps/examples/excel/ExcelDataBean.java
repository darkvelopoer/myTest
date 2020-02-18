package com.myapps.examples.excel;

import java.util.HashMap;

public class ExcelDataBean{ 

	private String [][] type = null;
	private String [][] data = null;
	private String [][] typeDesc = null;

	private boolean ownTableGap = false;
	private int tableGap = 0;

	private HashMap typeBorderStyle = null;
	private HashMap dataBorderStyle = null;
	private String columnSeparate = "≡";

	/**
	 * shrek
	 * 엑셀다운로드 컬럼 순서변경로직 추가
	 * @return
	 */
	private String excelColumnList;

	public String[][] getType() {
		return this.excelColumnType();
	}
	public void setType(String[][] type) {
		this.type = type;
	}
	public String[][] getData() {
		return this.excelColumnData();
	}
	public void setData(String[][] data) {
		this.data = data;
	}
	public boolean isOwnTableGap() {
		return ownTableGap;
	}
	public void setOwnTableGap(boolean ownTableGap) {
		this.ownTableGap = ownTableGap;
	}
	public int getTableGap() {
		return tableGap;
	}
	public void setTableGap(int tableGap) {
		this.tableGap = tableGap;
	}
	public HashMap getTypeBorderStyle() {
		return typeBorderStyle;
	}
	public void setTypeBorderStyle(HashMap typeBorderStyle) {
		this.typeBorderStyle = typeBorderStyle;
	}
	public HashMap getDataBorderStyle() {
		return dataBorderStyle;
	}
	public void setDataBorderStyle(HashMap dataBorderStyle) {
		this.dataBorderStyle = dataBorderStyle;
	}


	public void setExcelColumnList(String excelColumnList) {
		this.excelColumnList = excelColumnList;
	}
	/**
	 * shrek
	 * 엑셀다운로드 컬럼 순서변경로직 추가
	 * @return
	 */
	private String[][] excelColumnType() {
		if(this.excelColumnList != null && !"".equals(this.excelColumnList)) {
			String[] excelColumn = this.excelColumnList.split("/");
			int excelSize = excelColumn.length;
			String[][] newType = null;
	    	newType = new String[excelSize][2];
	        for(int i = 0; i < excelSize; i++ ) {
	    		int columns = Integer.parseInt(excelColumn[i]);
	    		newType[i][0] = this.type[columns][0];
	    		newType[i][1] = this.type[columns][1];
	    	}
	        return newType;
		} else {
			return this.type;
		}
	}

	private String[][] excelColumnData() {
		if(this.excelColumnList != null && !"".equals(this.excelColumnList)) {
			String[] excelColumn = this.excelColumnList.split("/");

			int excelColumnSize = excelColumn.length;
			int cellDataSize = this.data.length;

			String[][] cellData = new String[cellDataSize][excelColumnSize];

	        for(int i = 0; i < cellDataSize; i++ ) {
	        	for(int k = 0; k < excelColumnSize; k++) {
	        		//int[] aa = (int[]) String[] 이게 안되네
	        		int columns = Integer.parseInt(excelColumn[k]);
		    		cellData[i][k] = this.data[i][columns];
	        	}
	    	}
	        return cellData;
		} else {
			return this.data;
		}
	}

	public String excelColumnPublishing() {
		StringBuilder columnName = new StringBuilder();
		for(int i = 0; i < this.type.length; i++ ) {
			if(i == 0) {
				columnName.append(i).append(columnSeparate).append(this.type[i][0]);
			} else {
				columnName.append(columnSeparate).append(i).append(columnSeparate).append(this.type[i][0]);
			}
		}
	return columnName.toString();
	}
	
	public String[][] getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String[][] typeDesc) {
		this.typeDesc = typeDesc;
	}



}