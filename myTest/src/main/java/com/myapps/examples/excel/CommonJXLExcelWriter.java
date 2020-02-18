package com.myapps.examples.excel;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.ScriptStyle;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Blank;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class CommonJXLExcelWriter{

	private static String filePath = "c:\\tmp";//GlobalMessageUtil.getMessage("msg_jv_1575"); //"c:\\엑셀파일생성.xls";

	//한 시트당 row 수
	//왠만해선 65000을 수정하지 말고 그대로 둔다.
	private int maxRowPerSheer = 65000;



	//문서 제목 위의 공백 라인수
	private int titleTopBlankLine = 1;

	//문서 제목 아래의 공백 라인수
	private int titleBottomBlankLine = 2;

	//문서 제목 merge 열 수.
	private int titleMergeColCnt = 15;

	//문서 제목 merge 행 수
	private int titleMergeRowCnt = 2;

	//테이블 사이 간격
	private int tableGap = 2;






	//문서 제목 폰트 설정.
	//글씨체, 크기, 굵기, 이탤릭
	private WritableFont titleFont = new WritableFont(WritableFont.createFont("굴림"), 24, WritableFont.BOLD, false);
	//글 배경색.
	private Colour titleColor = Colour.YELLOW;

	//테이블 제목 폰트 설정.
	//글씨체, 크기
	private WritableFont typeFont = new WritableFont(WritableFont.createFont("굴림"), 10);
	//글 배경색.
	private Colour typeColor = Colour.YELLOW;
	private Colour typeDescColor = Colour.PINK;








	//DATE 형 포맷설정
	private DateFormat customDateFormat = new DateFormat ("yyyy-MM-dd hh:mm:ss");
	//private DateFormat customDateFormat = new DateFormat ("yyyy-MMM-dd hh:mm:ss");

	//DOUBLE 형 포맷설정
	//WritableCellFormat floatFormat = new WritableCellFormat (NumberFormats.THOUSANDS_FLOAT);
	private NumberFormat fFormat = new NumberFormat("###,##0.##");
	//INTEGER 형 포맷설정
	//WritableCellFormat integerFormat = new WritableCellFormat (NumberFormats.THOUSANDS_INTEGER);
	private NumberFormat iFormat = new NumberFormat("#,##0");




	public int getTitleTopBlankLine() {
		return titleTopBlankLine;
	}

	public void setTitleTopBlankLine(int titleTopBlankLine) {
		this.titleTopBlankLine = titleTopBlankLine;
	}

	public int getTitleBottomBlankLine() {
		return titleBottomBlankLine;
	}

	public void setTitleBottomBlankLine(int titleBottomBlankLine) {
		this.titleBottomBlankLine = titleBottomBlankLine;
	}

	public int getTitleMergeColCnt() {
		return titleMergeColCnt;
	}

	public void setTitleMergeColCnt(int titleMergeColCnt) {
		this.titleMergeColCnt = titleMergeColCnt;
	}

	public int getTitleMergeRowCnt() {
		return titleMergeRowCnt;
	}

	public void setTitleMergeRowCnt(int titleMergeRowCnt) {
		this.titleMergeRowCnt = titleMergeRowCnt;
	}

	public int getTableGap() {
		return tableGap;
	}

	public void setTableGap(int tableGap) {
		this.tableGap = tableGap;
	}

	public WritableFont getTitleFont() {
		return titleFont;
	}

	public void setTitleFont(WritableFont titleFont) {
		this.titleFont = titleFont;
	}

	public int getMaxRowPerSheer() {
		return maxRowPerSheer;
	}

	public void setMaxRowPerSheer(int maxRowPerSheer) {
		this.maxRowPerSheer = maxRowPerSheer;
	}


	public DateFormat getCustomDateFormat() {
		return customDateFormat;
	}

	public void setCustomDateFormat(DateFormat customDateFormat) {
		this.customDateFormat = customDateFormat;
	}

	public Colour getTitleColor() {
		return titleColor;
	}

	public void setTitleColor(Colour titleColor) {
		this.titleColor = titleColor;
	}

	public WritableFont getTypeFont() {
		return typeFont;
	}

	public void setTypeFont(WritableFont typeFont) {
		this.typeFont = typeFont;
	}

	public Colour getTypeColor() {
		return typeColor;
	}

	public void setTypeColor(Colour typeColor) {
		this.typeColor = typeColor;
	}

	public NumberFormat getFFormat() {
		return fFormat;
	}

	public void setFFormat(NumberFormat format) {
		this.fFormat = format;
	}

	public NumberFormat getIFormat() {
		return iFormat;
	}

	public void setIFormat(NumberFormat format) {
		this.iFormat = format;
	}


	public static void main(String[] args)  {
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;

		File excelFile = new File(filePath);
		Label label = null;
		Number num = null;
		long start = 0;
		long end = 0;



		try {

			workbook = Workbook.createWorkbook(excelFile);
			workbook.createSheet("sheet1", 0);
			sheet = workbook.getSheet(0);



			new WritableCellFormat(new WritableFont (WritableFont.ARIAL, 9,WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK,ScriptStyle.NORMAL_SCRIPT));




			//font
			WritableFont times16font = new WritableFont(WritableFont.TIMES, 16, WritableFont.BOLD, true);
			WritableCellFormat times16format = new WritableCellFormat (times16font);


			WritableFont arial10font = new WritableFont(WritableFont.createFont("굴림"), 20);
			WritableCellFormat arial10format = new WritableCellFormat (arial10font);

			Label label2 = new Label(0,1, "ggg", arial10format);
			sheet.addCell(label2);


			//Label label3 = new Label(2, 0, "Another Arial 10 point label", arial10format);
			//sheet.addCell(label3);


			//WritableCellFormat stringFormat = new WritableCellFormat ();
			//stringFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
//			Label dataLabel = new Label(0, 2, "0012",stringFormat);
//			sheet.addCell(dataLabel);



			WritableCellFormat stringFormat = new WritableCellFormat (NumberFormats.TEXT);

			Label dataLabel = new Label(0, 2, "",stringFormat);
			sheet.addCell(dataLabel);



			//number
			WritableCellFormat integerFormat = new WritableCellFormat (NumberFormats.INTEGER);
			Number number2 = new Number(0, 4, 0, integerFormat);
			sheet.addCell(number2);

			//WritableCellFormat floatFormat = new WritableCellFormat (NumberFormats.THOUSANDS_FLOAT);
			NumberFormat sFormat = new NumberFormat("###,##0.##");
			WritableCellFormat floatFormat = new WritableCellFormat (sFormat);
			Number number3 = new Number(1, 4, 0.141519, floatFormat);
			sheet.addCell(number3);


			final double pie = 3.141519;
			NumberFormat fivedps = new NumberFormat("#.#####");
			WritableCellFormat fivedpsFormat = new WritableCellFormat(fivedps);
			Number number4 = new Number(2, 4, pie, fivedpsFormat);
			sheet.addCell(number4);


			WritableCellFormat fivedpsFontFormat = new WritableCellFormat (times16font, fivedps);
			Number number5 = new Number(3, 4, pie, fivedpsFontFormat);
			sheet.addCell(number5);


			//DATE

			//DATE는 입력 값을 20091231 또는 20091231235959 이런 식으로 받아야 한다.
			int year = 2009;
			int month = 12;
			int day = 31;
			int hour = 0;
			int min = 0;
			int sec = 0;


			Date now = new Date(year-1900,month-1,day,hour,min,sec);
			//DateFormat customDateFormat = new DateFormat ("dd MMM yyyy hh:mm:ss");
			DateFormat customDateFormat = new DateFormat ("yyyy-MMM-dd");

			WritableCellFormat dateFormat = new WritableCellFormat (customDateFormat);
			DateTime dateCell = new DateTime(0, 6, now, dateFormat);
			sheet.addCell(dateCell);



			num = new jxl.write.Number( 0, 3, 100);
			sheet.addCell(num);



			workbook.write();
			workbook.close();
		}    catch( Exception e)    {
			//System.out.println("ERROR"+e.getMessage());
		}
	}

	public void jxlExelWriter(String title, ExcelDataBean [] dataBean, int rowPerSheet, OutputStream out)throws IOException, WriteException{
		WritableWorkbook workbook = Workbook.createWorkbook(out);

		boolean bExistsTitle = true;
		if(null == title || "".equals(title)){
			bExistsTitle = false;
		}

		int rownum = 0;
		int sheetNum = 0;

		// 시작시 titleTopBlankLine+1 를 세팅한 이유는 공백+문서 제목 때문.
		int totalCount = 0;

		if(bExistsTitle){
			totalCount+=this.titleTopBlankLine+1;
		}

		int dataTotalCount = 0;

		for(int i = 0; i<dataBean.length; i++){
			if(null!=dataBean[i]){
				if(null!=dataBean[i].getType()){
					totalCount += dataBean[i].getType().length;
					dataTotalCount += dataBean[i].getType().length;
				}
				if(null!=dataBean[i].getData()){
					totalCount += dataBean[i].getData().length;
					dataTotalCount += dataBean[i].getData().length;
				}
			}
			totalCount +=this.tableGap;
		}


		//만약 시트당 로우수가 maxRowPerSheer을 넘으면 강제로 maxRowPerSheer으로 세팅
		//왠만해선 65000을 수정하지 말고 그대로 둔다.
		if(rowPerSheet>this.maxRowPerSheer){
			rowPerSheet = this.maxRowPerSheer;
		}
		//만약 시트당 로우수가 65000이 넘으면 강제로 65000으로 세팅 끝.


		WritableSheet sheet = workbook.createSheet("Sheet", sheetNum);
		sheetNum++;

		//제목 위에 구분 공백
		for(int i = 0 ; bExistsTitle && i<this.titleTopBlankLine; i++){
			rownum = addBlankRow(sheet,rownum);
		}
        //제목 위에 구분 공백 끝

		//제목 생성
		if(bExistsTitle){
	        rownum = createTitle(sheet, rownum, dataBean, title);
		}
        //제목 생성 끝


        //제목 아래의  공백
		if(bExistsTitle){
			for(int i = 0 ; i<this.titleBottomBlankLine; i++){
				rownum = addBlankRow(sheet,rownum);
			}
		}
        //제목 아래의  공백 끝


        for(int all=0; all<dataBean.length; all++){

        	String [][] type=dataBean[all].getType();


	        //이제 data type(각 셀들의 명) 을 뿌려준다.
	        //type 셀 생성.
	        //type의 제목이 없는 것이 있을 수 있다. 그러면 data 타입만 필요하므로 실제 type을 출력하지는 않는다.
	        boolean existsType=false;
	        for(int i =0; i<type.length;i++){
	        	if(null!=type[i][0]&&!"".equals(type[i][0])){
	        		existsType=true;
	        		break;
	        	}
	        }
	        if(existsType){
		        for(int i =0; i<type.length;i++){
		        	HashMap tmpMap = new HashMap();
		        	tmpMap = addTypeCell(workbook, sheet, rownum, i, type, rowPerSheet, sheetNum);
		        	sheet = (WritableSheet)(tmpMap.get("sheet"));
		        	rownum = Integer.parseInt(tmpMap.get("rownum").toString());
		        	sheetNum = Integer.parseInt(tmpMap.get("sheetNum").toString());

		        }
		        rownum++;
	        }
	        //type의 제목이 없는 것이 있을 수 있다. 그러면 data 타입만 필요하므로 실제 type을 출력하지는 않는다. 끝
	        //type 셀 생성. 끝

        	String [][] typeDesc=dataBean[all].getTypeDesc();
	        //이제 data typeDesc(설명) 을 뿌려준다.
	        //typeDesc 셀 생성.
	        //typeDesc 제목이 없는 것이 있을 수 있다. 그러면 data 타입만 필요하므로 실제 typeDesc을 출력하지는 않는다.

        	if (typeDesc != null) {
		        boolean existsTypeDesc=false;
		        for(int i =0; i<typeDesc.length;i++){
		        	if(null!=typeDesc[i][0]&&!"".equals(typeDesc[i][0])){
		        		existsTypeDesc=true;
		        		break;
		        	}
		        }
		        if(existsTypeDesc){
			        for(int i =0; i<typeDesc.length;i++){
			        	HashMap tmpMap = new HashMap();
			        	tmpMap = addTypeDescCell(workbook, sheet, rownum, i, typeDesc, rowPerSheet, sheetNum);
			        	sheet = (WritableSheet)(tmpMap.get("sheet"));
			        	rownum = Integer.parseInt(tmpMap.get("rownum").toString());
			        	sheetNum = Integer.parseInt(tmpMap.get("sheetNum").toString());

			        }
			        rownum++;
		        }
		        //typeDesc의 제목이 없는 것이 있을 수 있다. 그러면 data 타입만 필요하므로 실제 typeDesc을 출력하지는 않는다. 끝
		        //typeDesc 셀 생성. 끝
		    }



	        //data 셀 생성.
	        String [][] data=dataBean[all].getData();

	        for(int i=0; null!=data && i<data.length;i++){
	        	for(int j =0;j<data[i].length;j++){
        			HashMap tmpMap = new HashMap();
        			tmpMap = addDataCell(workbook, sheet, rownum, j, data[i][j], rowPerSheet, sheetNum,type, type[j][1]);
  	        		sheet = (WritableSheet)(tmpMap.get("sheet"));
		        	rownum = Integer.parseInt(tmpMap.get("rownum").toString());
		        	sheetNum = Integer.parseInt(tmpMap.get("sheetNum").toString());
	        	}
	        	rownum++;
	        }
	        //data 셀 생성. 끝


	        //테이블 간격
	        //각기 설정한 간격이 있으면 그걸 따른다.
	        if(dataBean[all].isOwnTableGap()){
	        	for(int i = 0 ; i<dataBean[all].getTableGap(); i++){
	        		rownum = addBlankRow(sheet,rownum);
	        	}
	        }else{
	        	for(int i = 0 ; i<this.tableGap; i++){
	        		rownum = addBlankRow(sheet,rownum);
	        	}
	        }
	        //테이블 간격 삽입.
        }

        try{
	        workbook.write();
			workbook.close();
        }catch(Exception e){
        	//System.out.println("ERROR :"+e.getMessage());
        }


	}

	//문서 제목 생성 method.
	private int createTitle(WritableSheet sheet,int rownum, ExcelDataBean [] dataBean, String title)throws WriteException{

		WritableCellFormat titleFormat = new WritableCellFormat (this.titleFont);
		titleFormat.setAlignment(Alignment.CENTRE);
		titleFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
		titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		titleFormat.setBackground(this.titleColor);


		Label titleLabel = new Label(0, this.titleTopBlankLine, title, titleFormat);
		sheet.addCell(titleLabel);

		//열, 행, 열, 행
		sheet.mergeCells(0, this.titleTopBlankLine, this.titleMergeColCnt, this.titleTopBlankLine+this.titleMergeRowCnt-1);

	    return (rownum+this.titleMergeRowCnt);
	}

	//공백 생성 method
	private int addBlankRow(WritableSheet sheet,int rownum)throws WriteException{
		WritableCellFormat blankFormat = new WritableCellFormat();

		Blank blank = new Blank(0, rownum, blankFormat);
	    sheet.addCell(blank);

	    return (rownum+1);
	}

 	//TYPE을 쓰는 method
	private HashMap addTypeCell(WritableWorkbook workbook, WritableSheet sheet,int rownum, int colnum, String [][] type, int rowPerSheet, int sheetNum)throws WriteException{

		HashMap mRtn = new HashMap();

		if(rownum>=rowPerSheet){
			//새로운 셀을 생성 후 rownum을 0으로
			sheet = workbook.createSheet("Sheet"+sheetNum, sheetNum);
			sheetNum++;
			rownum = 0;
			//공백 생성
			rownum = addBlankRow(sheet,rownum);
		}

		WritableCellFormat typeFormat = new WritableCellFormat (typeFont);
		typeFormat.setAlignment(Alignment.CENTRE);
		typeFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
		typeFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		typeFormat.setBackground(this.typeColor);

        Label typeLabel = new Label(colnum, rownum, type[colnum][0], typeFormat);
		sheet.addCell(typeLabel);

		mRtn.put("sheet", sheet);
		mRtn.put("rownum", rownum);
		mRtn.put("sheetNum", sheetNum);

		return mRtn;

	}

 	//TYPE DESC을 쓰는 method
	private HashMap addTypeDescCell(WritableWorkbook workbook, WritableSheet sheet,int rownum, int colnum, String [][] typeDesc, int rowPerSheet, int sheetNum)throws WriteException{

		HashMap mRtn = new HashMap();

		if(rownum>=rowPerSheet){
			//새로운 셀을 생성 후 rownum을 0으로
			sheet = workbook.createSheet("Sheet"+sheetNum, sheetNum);
			sheetNum++;
			rownum = 0;
			//공백 생성
			rownum = addBlankRow(sheet,rownum);
		}

		WritableCellFormat typeFormat = new WritableCellFormat (typeFont);
		typeFormat.setAlignment(Alignment.CENTRE);
		typeFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
		typeFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		typeFormat.setBackground(this.typeDescColor);
		typeFormat.setWrap(true);

        Label typeLabel = new Label(colnum, rownum, typeDesc[colnum][0], typeFormat);
		sheet.addCell(typeLabel);

		mRtn.put("sheet", sheet);
		mRtn.put("rownum", rownum);
		mRtn.put("sheetNum", sheetNum);

		return mRtn;

	}




	//data를 쓰는 method
	private HashMap addDataCell(WritableWorkbook workbook, WritableSheet sheet,int rownum, int colnum, String data, int rowPerSheet, int sheetNum, String [][] type, String dataType)throws WriteException{

		HashMap mRtn = new HashMap();


		if(rownum>=rowPerSheet){
			//새로운 셀을 생성 후 rownum을 0으로
			sheet = workbook.createSheet("Sheet"+sheetNum, sheetNum);
			sheetNum++;
			rownum = 0;
			//공백 생성
			rownum = addBlankRow(sheet,rownum);
			//type 새로 써주기.

			boolean existsType=false;
	        for(int i =0; i<type.length;i++){
	        	if(!"".equals(type[i][0])){
	        		existsType=true;
	        		break;
	        	}
	        }
	        if(existsType){
		        for(int i =0; i<type.length;i++){
		        	HashMap tmpMap = new HashMap();

		        	tmpMap = addTypeCell(workbook, sheet, rownum, i, type, rowPerSheet, sheetNum);
		        	sheet = (WritableSheet)(tmpMap.get("sheet"));
		        	rownum = Integer.parseInt(tmpMap.get("rownum").toString());
		        	sheetNum = Integer.parseInt(tmpMap.get("sheetNum").toString());
		        }
		        rownum++;
	        }

		}


		if(null== data || "".equals(data)){
			WritableCellFormat stringFormat = new WritableCellFormat (NumberFormats.TEXT);
			stringFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			Label emptyLabel = new Label(colnum, rownum, "",stringFormat);
			sheet.addCell(emptyLabel);
		}else{

			//아래와 같이 setWrap를 하는 이유 : 하나의 셀에서 여러 줄의 data가 들어갈 수 있게 하기 위해.
			//WritableCellFormat stringFormat = new WritableCellFormat ();
			//stringFormat.setWrap(true);

			data = data.replaceAll("\r\n", "\n");
			try{
				if("INT".equals(dataType.toUpperCase())){
					//WritableCellFormat integerFormat = new WritableCellFormat (NumberFormats.THOUSANDS_INTEGER);
					WritableCellFormat integerFormat = new WritableCellFormat (iFormat);
					integerFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
					integerFormat.setWrap(true);
					Number dataLabel = new Number(colnum, rownum, Long.parseLong(data.replaceAll(",", "")), integerFormat);
					dataLabel.setCellFormat(integerFormat);
					sheet.addCell(dataLabel);
				}else if("DOUBLE".equals(dataType.toUpperCase())){
					//WritableCellFormat floatFormat = new WritableCellFormat (NumberFormats.THOUSANDS_FLOAT);
					WritableCellFormat floatFormat = new WritableCellFormat (fFormat);
					floatFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
					floatFormat.setWrap(true);
					Number dataLabel = new Number(colnum, rownum, Double.parseDouble(data.replaceAll(",", "")), floatFormat);
					dataLabel.setCellFormat(floatFormat);
					sheet.addCell(dataLabel);
				}else if("STRING".equals(dataType.toUpperCase())){
					WritableCellFormat stringFormat = new WritableCellFormat ();
					stringFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
					Label dataLabel = new Label(colnum, rownum, data,stringFormat);
					sheet.addCell(dataLabel);
				}else if("DATE".equals(dataType.toUpperCase())){
					//DATE는 입력 값을 20091231 또는 20091231235959 이런 식으로 받아야 한다.
					int year = Integer.parseInt(data.substring(0,4));
					int month = Integer.parseInt(data.substring(4,6));
					int day = Integer.parseInt(data.substring(6,8));
					int hour = 0;
					int min = 0;
					int sec = 0;

					if(data.length()==14){
						hour = Integer.parseInt(data.substring(8,10));
						min = Integer.parseInt(data.substring(10,12));
						sec = Integer.parseInt(data.substring(12,14));
					}

					WritableCellFormat dateFormat = new WritableCellFormat (this.customDateFormat);
					dateFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
					dateFormat.setWrap(true);
					DateTime dateCell = new DateTime(colnum, rownum, new Date(year-1900,month-1,day,hour,min,sec), dateFormat);
					sheet.addCell(dateCell);

				}else{
					WritableCellFormat stringFormat = new WritableCellFormat (NumberFormats.TEXT);
					stringFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
					stringFormat.setWrap(true);
					Label dataLabel = new Label(colnum, rownum, data,stringFormat);
					sheet.addCell(dataLabel);
				}
			}catch(Exception e){
				WritableCellFormat stringFormat = new WritableCellFormat (NumberFormats.TEXT);
				stringFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
				stringFormat.setWrap(true);
				Label dataLabel = new Label(colnum, rownum, data,stringFormat);
				sheet.addCell(dataLabel);
			}
		}

		mRtn.put("sheet", sheet);
		mRtn.put("rownum", rownum);
		mRtn.put("sheetNum", sheetNum);

		return mRtn;

	}

}
