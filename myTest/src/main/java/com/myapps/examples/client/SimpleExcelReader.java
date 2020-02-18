package com.myapps.examples.client;
import org.apache.commons.text.StringSubstitutor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.myapps.examples.constant.QueryConstant;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class SimpleExcelReader {

    private static final String FILE_NAME = "D:\\tmp\\tms\\tempFile.xlsx";
	private static final String filePath = "D:\\tmp\\tms\\";
	
    public static void main(String[] args) {
    	String queryOne = QueryConstant.query1;
    	String queryTwo = QueryConstant.query2;
    	String queryThree = QueryConstant.query3;
    	
    	Map<String, String> valuesMap = new HashMap<String, String>();
    	List<String> allQueryStrList = new ArrayList<String>();
    	try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //int idx = currentCell.getcell.getRowIndex();
                    int cellIdx = currentCell.getColumnIndex();
                    
                    if (currentCell.getCellType() == CellType.STRING) {  //cellIdx == 0 && 
                    	if(cellIdx == 0) {
	                    	String invcNo = currentCell.getStringCellValue();
	                        System.out.println(invcNo + "--" + currentCell.getStringCellValue());
	                       	valuesMap.put("invcNo", invcNo);
                    	}/*else if (cellIdx == 1) {
                    		String dlvNo = currentCell.getStringCellValue(); //NumberToTextConverter.toText(currentCell.getNumericCellValue());
                            System.out.println(dlvNo + "---" + currentCell.getStringCellValue());//currentCell.getNumericCellValue()); //currentCell.getNumericCellValue()
                           	valuesMap.put("dlvNo", dlvNo);
                    	}*/
                        
                    } else if (currentCell.getCellType() == CellType.NUMERIC) {  //cellIdx == 1 && 
                    	//DataFormatter fm = new DataFormatter();
                    	//currentCell.setCellType(Cell.CELL_TYPE_STRING)
                    	String dlvNo = NumberToTextConverter.toText(currentCell.getNumericCellValue());
                        System.out.println(dlvNo + "---" + currentCell.getNumericCellValue()); //currentCell.getNumericCellValue()
                       	valuesMap.put("dlvNo", dlvNo);
                    }
                }
                
                StringSubstitutor sub = new StringSubstitutor(valuesMap);
                //String resolvedQueryOne = sub.replace(queryOne);
                String resolvedQueryTwo = sub.replace(queryTwo);
                //String resolvedQueryThree = sub.replace(queryThree);
                
                //System.out.println(resolvedQueryOne);
                System.out.println(resolvedQueryTwo);
                //System.out.println(resolvedQueryThree);
                //allQueryStrList.add(resolvedQueryOne);
                allQueryStrList.add(resolvedQueryTwo);
                //allQueryStrList.add(resolvedQueryThree);
                

            }
            writeFile(allQueryStrList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    private static void writeFile(List<String> queryStrList) throws IOException {
		Path path = Paths.get(filePath + "dailyQuery" + ".txt");
		try(BufferedWriter bw = Files.newBufferedWriter(path)) {
			
			for(String queryStr:queryStrList) {
				bw.write(queryStr);
				bw.newLine();
			}
		}
    }
}
