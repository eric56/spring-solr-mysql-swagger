package com.koin.controller;

import com.koin.dataimport.DataImportSolr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/import")
public class ImportController {

    @Autowired
    private DataImportSolr dataImportSolr;

    @RequestMapping(value = "/dataImport/{command}", method = RequestMethod.GET)
    public @ResponseBody String importSolr(@PathVariable String command){

        dataImportSolr.importDataByCommand(command);

        return "Ok";
    }

}
