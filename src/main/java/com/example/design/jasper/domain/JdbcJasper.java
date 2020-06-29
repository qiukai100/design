package com.example.design.jasper.domain;


import com.example.design.jasper.constants.DBType;
import com.example.design.jasper.domain.base.BaseEntity;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcJasper extends BaseEntity {

    private DBType dbType;

    private String ip;

    private Integer port;

    private String dbName;

    private String userName;

    private String password;

    public JdbcJasper(InputStream jasperFile) {
        super(jasperFile);
    }

    @Override
    public JasperPrint getJasperPrint() throws JRException, ClassNotFoundException, SQLException {
        Class.forName(getDbType().getClassName());
        try (Connection connection = DriverManager.getConnection(getUrl(), getUserName(), getPassword())) {
            return getJasperPrint(connection);
        }
    }

    public String getUrl() {
        if (dbType == null) {
            return null;
        } else if (dbType == DBType.ORACLE) {
            return "jdbc:oracle:thin:@".concat(ip).concat(":").concat(String.valueOf(port)).concat(":").concat(dbName);
        } else if (dbType == DBType.MYSQL || dbType == DBType.MYSQL8x) {
            return "jdbc:mysql://".concat(ip).concat(":").concat(String.valueOf(port)).concat("/").concat(dbName).concat("?useSSL=false&serverTimezone=UTC");
        }
        return null;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DBType getDbType() {
        return dbType;
    }

    public void setDbType(DBType dbType) {
        this.dbType = dbType;
    }
}
