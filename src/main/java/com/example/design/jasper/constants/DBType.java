package com.example.design.jasper.constants;

public enum DBType {
    ORACLE("oracle.jdbc.driver.OracleDriver"),
    MYSQL("com.mysql.jdbc.Driver"),
    MYSQL8x("com.mysql.cj.jdbc.Driver");
    ;
    private String className;

    DBType(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}
