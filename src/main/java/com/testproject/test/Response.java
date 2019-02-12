package com.testproject.test;

import java.sql.Timestamp;

public class Response {
	private final Long timestamp;
	private final Long code;
    private final String description;
    private final String[] list;
    
    public Response(Long code, String description, String[] list) {

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        this.timestamp = ts.getTime();
        this.code = code;
        this.description = description;
        this.list = list;
    }
    public Long getTimestamp() {
        return timestamp;
    }
    public Long getCode() {
    	return code;
    }
    public String getDescription() {
    	return description;
    }
    public String[] getList() {
    	return list;
    }
    
}
