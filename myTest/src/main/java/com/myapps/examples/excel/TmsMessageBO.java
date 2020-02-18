package com.myapps.examples.excel;

import java.io.Serializable;



public class TmsMessageBO extends BaseBO implements Serializable{
	
	/**
	 * Object to store Tms related parameters
	 */
	private static final long serialVersionUID = 8773653456067747909L;
	private String dlvNo;
	private long seqNo;
	private String tmsStatus;
	private String messageType;
	private String dlvMthdCd;
	private String dlvEtprsCd;
	private String invcNo;
	private String messageRequest;
	private String messageResponse;
	private String responseStatus;
	private String taskId;
	private String createNo;
	private String updateNo;
	private boolean updateStatus;
	
	private String ordNo; 
	private String ordPrdSeq;
	private String buyerMemNo;
	private String sellerMemNo;
	private String salesAmt;
	private String rcvrNm;
	private String rcvrDtlsAddr;
	private String rcvrMailNo;
	private String city;
	private String state;
	private String rcvrTlphn;
	private String totalInflWght;
	private String totalPrdVol;
	private String sortCode;
	private String statusCode; //for http 404, 401, 406, 404 error 

	private String memNm;
	private String memId;
	private String dtlsAddr;
	private String mailNo;
	private String gnrlTlphnNo;
	private String prtblTlphnNo;
	private String prdNm;
	private String prdNo;
	
	private String ordPrdStat;
	private String selPrc;
	private String dlvEtprsNm;
	private String[] arrOrdNo;
	private String updFromOrderConfirm = "N";
	private String cancelYN = "N";
	
	public String getDlvNo() {
		return dlvNo;
	}
	public void setDlvNo(String dlvNo) {
		this.dlvNo = dlvNo;
	}
	public long getSeqNo() {
		return seqNo;
	}
	public String getTmsStatus() {
		return tmsStatus;
	}
	public void setTmsStatus(String tmsStatus) {
		this.tmsStatus = tmsStatus;
	}
	public void setSeqNo(long seqNo) {
		this.seqNo = seqNo;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getDlvMthdCd() {
		return dlvMthdCd;
	}
	public void setDlvMthdCd(String dlvMthdCd) {
		this.dlvMthdCd = dlvMthdCd;
	}
	public String getDlvEtprsCd() {
		return dlvEtprsCd;
	}
	public void setDlvEtprsCd(String dlvEtprsCd) {
		this.dlvEtprsCd = dlvEtprsCd;
	}
	public String getInvcNo() {
		return invcNo;
	}
	public void setInvcNo(String invcNo) {
		this.invcNo = invcNo;
	}
	public String getMessageRequest() {
		return messageRequest;
	}
	public void setMessageRequest(String messageRequest) {
		this.messageRequest = messageRequest;
	}
	public String getMessageResponse() {
		return messageResponse;
	}
	public void setMessageResponse(String messageResponse) {
		this.messageResponse = messageResponse;
	}
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getCreateNo() {
		return createNo;
	}
	public void setCreateNo(String createNo) {
		this.createNo = createNo;
	}
	public String getUpdateNo() {
		return updateNo;
	}
	public void setUpdateNo(String updateNo) {
		this.updateNo = updateNo;
	}
	
	public boolean isUpdateStatus() {
		return updateStatus;
	}
	public void setUpdateStatus(boolean updateStatus) {
		this.updateStatus = updateStatus;
	}
	public String getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
	}
	public String getOrdPrdSeq() {
		return ordPrdSeq;
	}
	public void setOrdPrdSeq(String ordPrdSeq) {
		this.ordPrdSeq = ordPrdSeq;
	}
	public String getBuyerMemNo() {
		return buyerMemNo;
	}
	public void setBuyerMemNo(String buyerMemNo) {
		this.buyerMemNo = buyerMemNo;
	}
	public String getSellerMemNo() {
		return sellerMemNo;
	}
	public void setSellerMemNo(String sellerMemNo) {
		this.sellerMemNo = sellerMemNo;
	}
	public String getSalesAmt() {
		return salesAmt;
	}
	public void setSalesAmt(String salesAmt) {
		this.salesAmt = salesAmt;
	}
	public String getRcvrNm() {
		return rcvrNm;
	}
	public void setRcvrNm(String rcvrNm) {
		this.rcvrNm = rcvrNm;
	}

	public String getRcvrDtlsAddr() {
		return rcvrDtlsAddr;
	}
	public void setRcvrDtlsAddr(String rcvrDtlsAddr) {
		this.rcvrDtlsAddr = rcvrDtlsAddr;
	}
	public String getRcvrMailNo() {
		return rcvrMailNo;
	}
	public void setRcvrMailNo(String rcvrMailNo) {
		this.rcvrMailNo = rcvrMailNo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRcvrTlphn() {
		return rcvrTlphn;
	}
	public void setRcvrTlphn(String rcvrTlphn) {
		this.rcvrTlphn = rcvrTlphn;
	}
	public String getTotalInflWght() {
		return totalInflWght;
	}
	public void setTotalInflWght(String totalInflWght) {
		this.totalInflWght = totalInflWght;
	}
	public String getTotalPrdVol() {
		return totalPrdVol;
	}
	public void setTotalPrdVol(String totalPrdVol) {
		this.totalPrdVol = totalPrdVol;
	}
	public String getSortCode() {
		return sortCode;
	}
	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMemNm() {
		return memNm;
	}
	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}

	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getDtlsAddr() {
		return dtlsAddr;
	}
	public void setDtlsAddr(String dtlsAddr) {
		this.dtlsAddr = dtlsAddr;
	}
	public String getMailNo() {
		return mailNo;
	}
	public void setMailNo(String mailNo) {
		this.mailNo = mailNo;
	}
	public String getGnrlTlphnNo() {
		return gnrlTlphnNo;
	}
	public void setGnrlTlphnNo(String gnrlTlphnNo) {
		this.gnrlTlphnNo = gnrlTlphnNo;
	}
	public String getPrtblTlphnNo() {
		return prtblTlphnNo;
	}
	public void setPrtblTlphnNo(String prtblTlphnNo) {
		this.prtblTlphnNo = prtblTlphnNo;
	}
	public String getPrdNm() {
		return prdNm;
	}
	public void setPrdNm(String prdNm) {
		this.prdNm = prdNm;
	}
	public String getPrdNo() {
		return prdNo;
	}
	public void setPrdNo(String prdNo) {
		this.prdNo = prdNo;
	}
	public String getOrdPrdStat() {
		return ordPrdStat;
	}
	public void setOrdPrdStat(String ordPrdStat) {
		this.ordPrdStat = ordPrdStat;
	}
	public String getSelPrc() {
		return selPrc;
	}
	public void setSelPrc(String selPrc) {
		this.selPrc = selPrc;
	}
	public String getDlvEtprsNm() {
		return dlvEtprsNm;
	}
	public void setDlvEtprsNm(String dlvEtprsNm) {
		this.dlvEtprsNm = dlvEtprsNm;
	}
	public String[] getArrOrdNo() {
		return arrOrdNo;
	}
	public void setArrOrdNo(String[] arrOrdNo) {
		this.arrOrdNo = arrOrdNo;
	}
	public String getUpdFromOrderConfirm() {
		return updFromOrderConfirm;
	}
	public void setUpdFromOrderConfirm(String updFromOrderConfirm) {
		this.updFromOrderConfirm = updFromOrderConfirm;
	}
	public String getCancelYN() {
		return cancelYN;
	}
	public void setCancelYN(String cancelYN) {
		this.cancelYN = cancelYN;
	}
	
}
