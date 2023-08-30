package org.example;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        Map<String, Object> parameters = new HashMap();

        parameters.put("SUBREPORT_DIR", "/Users/arturtodeschini//");

        List<TitularTermoSolidariedadeVO> titulares = new ArrayList<>(2);

        List<TermoVO> termos = new ArrayList<>(2);
        termos.add(new TermoVO());
        termos.add(new TermoVO());


        termos.get(0).setConta("0003.3701.0005999998689-5");
        termos.get(0).setLocal("Florianópolis/SC");

        LocalDate d1 = LocalDate.of(2021,7,1);
        Date dt = Date.from(d1.atStartOfDay(ZoneId.systemDefault()).toInstant());

        termos.get(0).setDataLocalizacao(dt);
        termos.get(0).setCpf("696.171.070-07");

        termos.get(1).setConta("0003.3701.0005999998689-5");
        termos.get(1).setLocal("Florianópolis/SC");
        termos.get(1).setDataLocalizacao(dt);
        termos.get(1).setCpf("570.614.610-12");


        for (TermoVO t: termos) {
            titulares.add( new TitularTermoSolidariedadeVO(t.getCpf()));
        }
        //"0003.3701.0005999998689-5"


        parameters.put("SUBREPORT_DATA", titulares);


        JasperReport report = getReport("/Users/arturtodeschini/MO38255v0001.jasper");
        JasperPrint relatorio = JasperFillManager.fillReport(report, parameters, new TermoSolidariedadeDS(termos));
        JasperViewer viewer = new JasperViewer(relatorio, false);
        viewer.setTitle("Demo Relatorios iReports");
        viewer.setVisible(true);
        viewer.show();
    }

    public static JasperReport getReport(String path) {
        FileInputStream is = null;

        try {
            is = new FileInputStream(path);
            return (JasperReport) JRLoader.loadObject(is);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
