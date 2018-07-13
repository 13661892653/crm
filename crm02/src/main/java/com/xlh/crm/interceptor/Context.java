package com.xlh.crm.interceptor;

import java.net.URL;

public abstract class Context {
    protected String content;
    public abstract void resolveContent(String filePath) throws  Exception;
    public abstract void resolveContent(URL url) throws Exception;

    public String getContent(){
        return content;
    }
}
