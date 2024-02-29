package com.example.sy.auth;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {
	public Map<String, Object> login (Map<String, Object> param);
	

}
