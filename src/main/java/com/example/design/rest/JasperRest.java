package com.example.design.rest;

import com.example.design.jasper.JasperHelper;
import com.example.design.jasper.domain.JsonJasper;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;

@RestController
@RequestMapping("jasper")
public class JasperRest {

    @Value("classpath:static/jasper/PH_I_POCUSTOMS_ORDER.jasper")
    private Resource jasperJson;

    @RequestMapping("showPdf")
    public void showPdf(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, JRException {
        // 实例化json打印实体，传入模板的流
        JsonJasper jsonJasper = new JsonJasper(jasperJson.getInputStream());
        String json = "{\r\n" +
                "    \"orderHead\":{\r\n" +
                "        \"templateType\":\"82ef65b0-939d-4bbf-a6a6-13dce2529423\",\r\n" +
                "        \"orderType\":\"M\",\r\n" +
                "        \"isDrawback\":\"Y\",\r\n" +
                "        \"natureExemption\":\"101\",\r\n" +
                "        \"effectiveTime\":1860940800000,\r\n" +
                "        \"agentCode\":\"4453065442\",\r\n" +
                "        \"loadingPortCode\":\"CHN000\",\r\n" +
                "        \"supplyLandCode\":\"11019\",\r\n" +
                "        \"customsNo\":\"G200035193\",\r\n" +
                "        \"tradeTerm\":\"3\",\r\n" +
                "        \"coDocumentType\":\"否\",\r\n" +
                "        \"homeWork\":\"关务复审\",\r\n" +
                "        \"customsOrderUuid\":\"b03d410b-bbd1-4b99-9692-70abe973ba36\",\r\n" +
                "        \"customsOrderType\":\"2\",\r\n" +
                "        \"relationshipConfirm\":\"否\",\r\n" +
                "        \"agentDesc\":\"深圳市涌玮鑫贸易有限公司\",\r\n" +
                "        \"officeCode\":\"QDJPC\",\r\n" +
                "        \"entyPortCode\":\"470001\",\r\n" +
                "        \"customsModelType\":\"一次清关\",\r\n" +
                "        \"isCustomsDeclaration\":\"N\",\r\n" +
                "        \"netWeight\":12,\r\n" +
                "        \"privilegeConfirm\":\"否\",\r\n" +
                "        \"shipperDesc\":\"深圳市涌玮鑫贸易有限公司\",\r\n" +
                "        \"entrustNo\":\"312321\",\r\n" +
                "        \"pkgtype\":\"23\",\r\n" +
                "        \"declareCompany\":\"4403180495\",\r\n" +
                "        \"recVer\":24,\r\n" +
                "        \"qty\":6,\r\n" +
                "        \"portCustoms\":\"5306\",\r\n" +
                "        \"inboundComplete\":\"Y\",\r\n" +
                "        \"superviseMode\":\"0110\",\r\n" +
                "        \"entrustType\":\"2\",\r\n" +
                "        \"declearDate\":1587088253000,\r\n" +
                "        \"status\":\"InEntrust\",\r\n" +
                "        \"aux3\":\"914403007827940352\",\r\n" +
                "        \"declareCustoms\":\"5306\",\r\n" +
                "        \"loadingCuntryCode\":\"CHN\",\r\n" +
                "        \"aux2\":\"914403007827940352\",\r\n" +
                "        \"controlWord\":\"I0000000000200000000\",\r\n" +
                "        \"destination\":\"ALB\",\r\n" +
                "        \"declearType\":\"Q\",\r\n" +
                "        \"remark\":\"一次清关备注\",\r\n" +
                "        \"jgxx\":\"未结关\",\r\n" +
                "        \"shipperCode\":\"4453065442\",\r\n" +
                "        \"expiryDate\":1589644800000,\r\n" +
                "        \"isFreeze\":\"N\",\r\n" +
                "        \"projectCode\":\"PTH\",\r\n" +
                "        \"isCresteFlag\":\"N\",\r\n" +
                "        \"ioBound\":\"E\",\r\n" +
                "        \"tradingCountry\":\"AFG\",\r\n" +
                "        \"statusName\":\"委托中\",\r\n" +
                "        \"extStatus\":\"TrackConfig\",\r\n" +
                "        \"consignorCname\":\"22\",\r\n" +
                "        \"customsType\":\"DECLEAR\",\r\n" +
                "        \"priceConfirm\":\"否\",\r\n" +
                "        \"customsBroker\":\"20043\",\r\n" +
                "        \"isCreateGtwo\":\"N\",\r\n" +
                "        \"agentConsigneeDesc\":\"青岛凯迪物流有限公司\",\r\n" +
                "        \"grossWeight\":34,\r\n" +
                "        \"templateName\":\"一次清关\",\r\n" +
                "        \"cotBatchNo\":\"LQDKEE2043344\",\r\n" +
                "        \"transWay\":\"1\",\r\n" +
                "        \"declareCustomsName\":\"笋岗海关\",\r\n" +
                "        \"portCustomsName\":\"笋岗海关\",\r\n" +
                "        \"billLadingNo\":\"\",\r\n" +
                "        \"consignorCode\":\"22\",\r\n" +
                "        \"containerNo\":\"\",\r\n" +
                "        \"containerType\":\"\",\r\n" +
                "        \"contractNo\":\"\",\r\n" +
                "        \"declareCompanyName\":\"\",\r\n" +
                "        \"declareCompanySocialCreditCode\":\"\",\r\n" +
                "        \"documentsCodes\":\"\",\r\n" +
                "        \"documentsNo\":\"\",\r\n" +
                "        \"entyPortCodeName\":\"\",\r\n" +
                "        \"extrasCurrency\":\"\",\r\n" +
                "        \"extrasFlag\":\"\",\r\n" +
                "        \"extrasRate\":\"\",\r\n" +
                "        \"freightCurrency\":\"\",\r\n" +
                "        \"freightFlag\":\"\",\r\n" +
                "        \"freightRate\":\"\",\r\n" +
                "        \"lbooksCheckNo\":\"\",\r\n" +
                "        \"licenceNo\":\"\",\r\n" +
                "        \"loadingCuntryDesc\":\"\",\r\n" +
                "        \"loadingPortDesc\":\"\",\r\n" +
                "        \"natureExemptionName\":\"\",\r\n" +
                "        \"pkgtypeName\":\"\",\r\n" +
                "        \"premiumCurrency\":\"\",\r\n" +
                "        \"premiumFlag\":\"\",\r\n" +
                "        \"premiumRate\":\"\",\r\n" +
                "        \"recordsNo\":\"\",\r\n" +
                "        \"superviseModeName\":\"\",\r\n" +
                "        \"tradeTermName\":\"\",\r\n" +
                "        \"tradingCountryName\":\"\",\r\n" +
                "        \"transTool\":\"\",\r\n" +
                "        \"transWayName\":\"\",\r\n" +
                "        \"voyage\":\"\"\r\n" +
                "    }\r\n" +
                "}";
        jsonJasper.setJsonData(json);
        jsonJasper.setNodeLabel("orderHead");
        JasperHelper.showPDF(jsonJasper, request, response);
    }
}
