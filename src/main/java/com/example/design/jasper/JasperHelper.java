package com.example.design.jasper;

import com.example.design.jasper.constants.DocType;
import com.example.design.jasper.domain.base.BaseEntity;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;

/**
 * jasper操作工具
 */
public class JasperHelper {

    /**
     * 打印PDF
     *
     * @param entity 打印规则实例
     * @param request 请求
     * @param response 响应
     * @throws IOException 流异常
     * @throws JRException JR异常
     */
    public static void showPDF(BaseEntity entity, HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, JRException, IOException {
        JasperPrint jasperPrint = entity.getJasperPrint();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setContentType("application/pdf");
        JRPdfExporter exporter = (JRPdfExporter) DocType.PDF.buildExporter();
        request.getSession().setAttribute(
                ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE,
                jasperPrint);
        try (OutputStream outputStream = response.getOutputStream()) {
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
            exporter.exportReport();
            outputStream.flush();
        }
    }
}
