package com.rays.subclass;

public class Cheque extends Payment{
	private String chequeNo;
	private String bankName;
	
	public String getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		bankName = bankName;
	}
	

}
