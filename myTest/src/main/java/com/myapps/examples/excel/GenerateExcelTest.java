package com.myapps.examples.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myapps.examples.util.DateTime;

import jxl.write.WriteException;

public class GenerateExcelTest {

	
	public void generateTmsShipmentOrdersReport(String filePath) throws Exception {
		List<TmsMessageBO> dataList = null; //tmsDAO.getTmsShipmentOrdersReport();
		Map<String, List<TmsMessageBO>> mapOfSellerData = new HashMap<>();
		//Put in map with seller mem id as key
		for (TmsMessageBO data : dataList) {
			if(mapOfSellerData.containsKey(data.getMemId())) {
				mapOfSellerData.get(data.getMemId()).add(data);
			}else {
				List<TmsMessageBO> dataLst = new ArrayList<>();
				dataLst.add(data);
				mapOfSellerData.put(data.getMemId(), dataLst);
			}
		}
		//Loop for each seller
		for (Map.Entry<String, List<TmsMessageBO>> entry : mapOfSellerData.entrySet()) {
			writeTmsShipmentOrdersReport(entry.getValue(), filePath + File.separator + entry.getKey() + "_" + DateTime.getShortDateString() + ".xls");
		}
		
	}
	
	private void writeTmsShipmentOrdersReport(List<TmsMessageBO> dataList, String fileName) {
		OutputStream responseOut = null;
		ExcelDataBean[] excelDataBean = new ExcelDataBean[1];
		excelDataBean[0] = new ExcelDataBean();

		String[][] cellData = null;
		String[][] newType = new String[12][2];
		int newCol = 0;
		newType[newCol++][0] = "Recipient Zipcode";
		newType[newCol++][0] = "Recipient Name";
		newType[newCol++][0] = "Recipient Address";
		newType[newCol++][0] = "Recipient Detail Address";
		newType[newCol++][0] = "Recipient Tel Number";
		newType[newCol++][0] = "Qty";
		newType[newCol++][0] = "Weight";
		newType[newCol++][0] = "Product Name";
		newType[newCol++][0] = "Remark1";
		newType[newCol++][0] = "Remark2";
		newType[newCol++][0] = "Bill Number";
		newType[newCol++][0] = "Client Order Number";

		int rowNum = 1;
		//int excelDataSize = dataList.size();
		if (dataList != null && !dataList.isEmpty()) {
			cellData = new String[dataList.size()][newType.length];
			for (TmsMessageBO data : dataList) {
				newCol = 0;

				cellData[rowNum - 1][newCol++] = data.getRcvrMailNo();
				cellData[rowNum - 1][newCol++] = data.getRcvrNm();
				cellData[rowNum - 1][newCol++] = data.getCity();
				cellData[rowNum - 1][newCol++] = data.getRcvrDtlsAddr();
				cellData[rowNum - 1][newCol++] = data.getRcvrTlphn();
				cellData[rowNum - 1][newCol++] = "1"; // Fixed to 1
				cellData[rowNum - 1][newCol++] = data.getTotalInflWght();
				cellData[rowNum - 1][newCol++] = data.getPrdNm();
				cellData[rowNum - 1][newCol++] = data.getPrdNo();
				cellData[rowNum - 1][newCol++] = "";
				cellData[rowNum - 1][newCol++] = data.getInvcNo();
				cellData[rowNum - 1][newCol++] = data.getOrdNo();
				rowNum += 1;
			}
		}
		CommonJXLExcelWriter jxlExcelWriter = new CommonJXLExcelWriter();
		excelDataBean[0].setType(newType);
		if (cellData != null) {
			excelDataBean[0].setData(cellData);
		} else {
			excelDataBean[0].setData(new String[0][0]);
		}
		
		try {
			responseOut = new FileOutputStream(fileName);
			jxlExcelWriter.jxlExelWriter("", excelDataBean, 60000, responseOut);

			responseOut.flush();
			responseOut.close();
		} catch (WriteException | IOException e) {
			try {
				if(responseOut!=null) {
					responseOut.flush();
					responseOut.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
		}

	}
}
