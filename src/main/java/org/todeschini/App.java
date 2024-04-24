package org.todeschini;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * Applicacao que demonstrar como usar Arquivos .jrxml que geram .jsasper
 */
public class App {
    public static void main(String[] args) throws Exception {
        Map<String, Object> parameters = new HashMap();

        TermoSolidariedadeVO vo = new TermoSolidariedadeVO();
        vo.setConta("0003.3701.0005999998689-5");
        vo.setLocal("Florianópolis/SC");
        vo.setDataLocalizacao(new Date());

        TitularTermoSolidariedadeVO t1 = new TitularTermoSolidariedadeVO();
        t1.setName("titular 1");
        t1.setCpf("982.245.390-67");

        TitularTermoSolidariedadeVO t2 = new TitularTermoSolidariedadeVO();
        t1.setName("titular 2");
        t1.setCpf("729.373.850-10");

        vo.getTitulares().add(t1);
        vo.getTitulares().add(t2);

        //JasperReport subAssinaturas = getReportByJrxmlFile("/src/main/resources/reports/MO38255_variacao1.jrxml");
        JasperReport subAssinaturas = getReportByJrxmlFile("/reports/MO38255_variacao1.jrxml");

        parameters.put("subAssinaturas",subAssinaturas);

//        JasperReport report = getReportByJrxmlFile("/src/main/resources/reports/MO38255v0001.jrxml");
        JasperReport report = getReportByJrxmlFile("/reports/MO38255v0001.jrxml");

        JasperPrint relatorio = JasperFillManager.fillReport(report, parameters, new TermoSolidariedadeDataSource(vo));
        JasperViewer viewer = new JasperViewer(relatorio, false);
        viewer.setTitle("Demo Relatorios iReports");
        viewer.setVisible(true);
        viewer.show();
    }

//    public Downloadable generatePDFReport() {
//        String data = invokeService();
//
//        logger.info("Calling connector to generate the jasperRepoet");
//        ByteArrayOutputStream pdfReportStream = (ByteArrayOutputStream) jasperConnector.generateReport(JasperExportType.PDF, "jasperReport/restApi.jrxml", new HashMap<>(), data);
//
//        DownloadResponse downloadableResponse = new DownloadResponse(new ByteArrayInputStream(pdfReportStream.toByteArray()), "application/pdf", "jasper.pdf");
//
//        downloadableResponse.setInline(false);
//
//        return downloadableResponse;
//    }

    public static JasperReport getReportByJasoerFile(String path) {
        FileInputStream is = null;

        try {
            is = new FileInputStream(path);
            return (JasperReport) JRLoader.loadObject(is);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static JasperReport getReportByJrxmlFile(String path) {
        //FileInputStream is = null;
        InputStream is = null;

        try {
//            is = new FileInputStream(path);
            is = App.class.getResourceAsStream(path);
            return JasperCompileManager.compileReport(is);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
