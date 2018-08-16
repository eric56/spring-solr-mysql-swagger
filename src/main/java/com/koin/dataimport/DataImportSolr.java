package com.koin.dataimport;

import com.koin.parser.JsonResponseParser;
import com.koin.utils.RequestUtil;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.common.params.SolrParams;
import org.apache.solr.common.util.ContentStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.solr.core.SolrCallback;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;

@EnableAutoConfiguration
@Service
public class DataImportSolr {

    @Autowired
    private SolrClient solrClient;

    @Autowired
    private RequestUtil requestUtil;

    public String importDataByCommand(String command) {

        String url = "http://localhost:8983/solr/usuarios/dataimport?command=" + command + "&clean=false&commit=true";

        try {
            return requestUtil.sendRequestGET(url);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}
