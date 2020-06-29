package com.example.design.rest;

import com.example.design.jasper.JasperHelper;
import com.example.design.jasper.domain.JsonJasper;
import net.sf.jasperreports.engine.JRException;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.sql.SQLException;

@RestController
@RequestMapping("jasper")
public class JasperRest {

    @Value("classpath:static/jasper/PH_I_POCUSTOMS_ORDER.jasper")
    private Resource jasperFile;

    @Value("classpath:static/json/data.json")
    private Resource dataJson;

    @RequestMapping("showPdf")
    public void showPdf(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, JRException {
        // 实例化json打印实体，传入模板的流
        JsonJasper jsonJasper = new JsonJasper(jasperFile.getInputStream());
        jsonJasper.setJsonData(IOUtils.toString(dataJson.getInputStream(), Charset.forName("UTF-8")));
        jsonJasper.setNodeLabel("orderHead");
        JasperHelper.showPDF(jsonJasper, request, response);
    }
}
