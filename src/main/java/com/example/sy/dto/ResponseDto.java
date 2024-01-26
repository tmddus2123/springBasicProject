package com.example.sy.dto;

import lombok.Getter;

@Getter
public class ResponseDto {
	private int code;
	private String msg;
	private Object data;
	
	public ResponseDto(Object body) {
		this.data = body;
	}
	
	public ResponseDto(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
}
