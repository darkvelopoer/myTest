package com.myapps.examples.constant;

public class QueryConstant {

	public static String query1 = "update tr_ord_prd set ord_prd_stat = '401', update_dt = sysdate where dlv_no = ${dlvNo};";
	public static String query2 = "update tr_ord_clm_dlv_dtls set dlv_etprs_cd = '20025' , invc_no = '${invcNo}', tms_status = '04', update_dt = sysdate where dlv_no = ${dlvNo};";
 
	public static String query3 = "insert into dlv_aftership_invc_mng (seq, invc_no, dlv_slug, invc_in_del_type, invc_confirm_type" +
			 ", create_dt, create_no, update_dt, update_no, delivered_update_by, tms_yn )" +
			 " values (" +
			 "SEQ_DLV_AFTERSHIP_INVC_MNG.nextval" +
			 ", '${invcNo}' " +
			 ", (select GOODSFLOW_ETPRS_CD from tr_trsnp_etprs_extr where use_yn='Y' and DLV_ETPRS_CD='20025' and rownum=1) " +
			 ", 'I'" +
			 ", 'Y'" +
			 ", sysdate" +
			 ", '1001'" + 
			 ", sysdate" + 
			 ", '1001'" + 
			 ", null" +
			 ",'Y'" +
			 ");";
}
