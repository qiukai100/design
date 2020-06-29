package com.example.design.jasper.domain;

import com.example.design.jasper.domain.base.BaseEntity;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JsonDataSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 根据Json数据源打印的实例
 */
public class JsonJasper extends BaseEntity {

    // json数据源
    private String jsonData;

    // 开始解析的节点名称
    private String nodeLabel;

    public JsonJasper(InputStream jasperFile) {
        super(jasperFile);
    }

    @Override
    public JasperPrint getJasperPrint() throws JRException, IOException {
        try (InputStream inputStream = new ByteArrayInputStream(getJsonData().getBytes())) {
            JRDataSource jrDataSource = new JsonDataSource(inputStream, getNodeLabel());
            return getJasperPrint(jrDataSource);
        }
    }

    public String getJsonData() {
        if (jsonData == null)
            return "";
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    public String getNodeLabel() {
        if (nodeLabel == null)
            return "";
        return nodeLabel;
    }

    public void setNodeLabel(String nodeLabel) {
        this.nodeLabel = nodeLabel;
    }
}
