package com.koin.parser;

import org.apache.solr.client.solrj.impl.XMLResponseParser;

public class JsonResponseParser extends XMLResponseParser {

    public JsonResponseParser(){
        super();
    }

    @Override
    public String getContentType() {
        return "application/json; charset=UTF-8";
    }

}
