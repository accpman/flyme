package com.flyme.core.springmvc.exception;

public class ErrorInfo {
	private String code = "101";
	private String info = "服务器异常";// 错r误信息

	public ErrorInfo() {

	}

	public ErrorInfo(Exception ex) {
		this.info = getErrorMessage(ex);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	private String getErrorMessage(Exception ex) {
		ex.printStackTrace();
		return "服务器异常";
	}
}
