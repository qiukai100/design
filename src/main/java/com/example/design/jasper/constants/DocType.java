package com.example.design.jasper.constants;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.export.*;

/**
 * 文档类型
 */
public enum DocType {
    PDF, HTML, XLS, XML, RTF;

    /**
     * 获取不同文档类型的打印实例
     *
     * @return 打印的实例
     */
    public JRAbstractExporter buildExporter() {
        JRAbstractExporter exporter = null;
        switch (this) {
            case PDF:
                exporter = new JRPdfExporter();
                break;
            case HTML:
                exporter = new HtmlExporter();
                break;
            case XLS:
                exporter = new JRXlsExporter();
                break;
            case XML:
                exporter = new JRXmlExporter();
                break;
            case RTF:
                exporter = new JRRtfExporter();
                break;
        }
        return exporter;
    }
}
