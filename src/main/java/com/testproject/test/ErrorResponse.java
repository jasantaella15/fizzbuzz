package com.testproject.test;

import java.sql.Timestamp;

public class ErrorResponse {
    private int status;
    private String error;
    private String message;
    private String path;
    private long timestamp;
     
    public ErrorResponse(int s, String e, String m, String p) {
    	this.status = s;
    	this.error = e;
    	this.message = m;
    	this.path = p;
    	Timestamp ts = new Timestamp(System.currentTimeMillis());
    	this.timestamp = ts.getTime();
    }
    public String getPath() {
        return path;
    }
    public String getError() {
        return error;
    }
    public int getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
    public long getTimestamp() {
    	return timestamp;
    }
}