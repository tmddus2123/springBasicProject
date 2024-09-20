package com.example.web.dto;

import java.util.Map;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ResponseDto {

	private Map<String, Object> header;
	private Map<String, Object> body;

	public ResponseDto(Map<String, Object> body) {
		this.body = body;
	}
}
