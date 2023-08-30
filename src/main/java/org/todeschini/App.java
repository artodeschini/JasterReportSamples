package org.example;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.FileInputStream;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        Map<String, Object> parameters = new HashMap();

        parameters.put("SUBREPORT_DIR", "/Users/arturtodeschini//");

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

        JasperReport subAssinaturas = getReportByJrxmlFile("");

        parameters.put("subAssinaturas",subAssinaturas);

        JasperReport report = getReportByJrxmlFile("/Users/arturtodeschini/MO38255v0001.jrxml");

        JasperPrint relatorio = JasperFillManager.fillReport(report, parameters, new TermoSolidariedadeDataSource(vo));
        JasperViewer viewer = new JasperViewer(relatorio, false);
        viewer.setTitle("Demo Relatorios iReports");
        viewer.setVisible(true);
        viewer.show();
    }

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
        FileInputStream is = null;

        try {
            is = new FileInputStream(path);
            return JasperCompileManager.compileReport(is);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
