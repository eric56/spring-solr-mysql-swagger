package com.koin.enums;

import lombok.Data;

@Data
public enum SolrCommandsEnum {

    //Comandos de importação
    DELTA_IMPORT("delta-import");

    private String command;

    SolrCommandsEnum(String command) {
        this.command = command;
    }

}
