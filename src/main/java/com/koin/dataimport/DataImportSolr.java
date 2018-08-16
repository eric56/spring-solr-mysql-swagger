package com.koin.dataimport;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.SolrResponseBase;
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
    private SolrTemplate solrTemplate;

    public void importDataByCommand(String command) {

        solrTemplate.execute(new SolrCallback<SolrResponse>() {
            @Override
            public SolrResponse doInSolr(SolrClient solrClient) throws SolrServerException, IOException {

                StringBuilder url = new StringBuilder();
                url.append("/usuarios/dataimport?command=").append(command);

                SolrRequest resquest = new SolrRequest(SolrRequest.METHOD.GET, url.toString()) {
                    @Override
                    public SolrParams getParams() {
                        return null;
                    }

                    @Override
                    public Collection<ContentStream> getContentStreams() throws IOException {
                        return null;
                    }

                    @Override
                    protected SolrResponse createResponse(SolrClient solrClient) {
                        return null;
                    }

                };

                resquest.setResponseParser(new XMLResponseParser());
                return resquest.process(solrClient);
            }
        });

    }

}
