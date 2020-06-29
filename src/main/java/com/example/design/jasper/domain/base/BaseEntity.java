package com.example.design.jasper.domain.base;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseEntity {

    // jasper模板文件输入流
    private InputStream jasperFile;

    // 传入的参数
    private Map<String, Object> parameters;

    public BaseEntity(InputStream jasperFile) {
        this.jasperFile = jasperFile;
    }

    public InputStream getJasperFile() {
        return jasperFile;
    }

    public Map<String, Object> getParameters() {
        if (parameters == null)
            return new HashMap<>();
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public abstract JasperPrint getJasperPrint() throws JRException, ClassNotFoundException, SQLException, IOException;

    protected JasperPrint getJasperPrint(JRDataSource jrDataSource) throws JRException {
        return JasperFillManager.fillReport(getJasperFile(),
                getParameters(), jrDataSource);
    }

    protected JasperPrint getJasperPrint(Connection connection) throws JRException {
        return JasperFillManager.fillReport(getJasperFile(),
                getParameters(), connection);
    }
}
