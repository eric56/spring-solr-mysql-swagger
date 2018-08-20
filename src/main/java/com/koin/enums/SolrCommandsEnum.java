package com.koin.enums;

public enum SolrCommandsEnum {

    //Comandos de importação
    DELTA_IMPORT("delta-import");

    private String command;

    SolrCommandsEnum(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
