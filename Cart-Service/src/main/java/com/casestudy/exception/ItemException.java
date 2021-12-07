package com.casestudy.exception;

public class ItemException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ErrCode;
	private String ErrMessage;
	public String getErrCode() {
		return ErrCode;
	}
	public void setErrCode(String errCode) {
		ErrCode = errCode;
	}
	public String getErrMessage() {
		return ErrMessage;
	}
	public void setErrMessage(String errMessage) {
		ErrMessage = errMessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ItemException(String errCode, String errMessage) {
		super();
		ErrCode = errCode;
		ErrMessage = errMessage;
	}
	public ItemException() {
		super();
	}
	@Override
	public String toString() {
		return "ItemException [ErrCode=" + ErrCode + ", ErrMessage=" + ErrMessage + "]";
	}

}
