package com.huseyn.messenger.resources;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {
    
    @QueryParam("year") int year;
    @QueryParam("start")int start;
    @QueryParam("size") int size;

    public int getYear() {
        return year;
    }

    public int getStart() {
        return start;
    }

    public int getSize() {
        return size;
    }
    
    
    
}
