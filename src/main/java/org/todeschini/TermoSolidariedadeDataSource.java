package org.todeschini;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class TermoSolidariedadeDataSource implements JRDataSource {

    private TermoSolidariedadeVO cursor;

    private boolean hasNext = true;


    public TermoSolidariedadeDataSource(TermoSolidariedadeVO termo) {
        cursor = termo;
    }

    @Override
    public boolean next() throws JRException {
        if (hasNext) {
            hasNext = false;
            return false;
        }
        return false;
    }

    @Override
    public Object getFieldValue(JRField field) throws JRException {
        TermoSolidariedadeVO t = this.cursor;

        if (field.getName().equals("conta")) {
            return t.getConta();
        }

        if (field.getName().equals("dataLocalizacao")) {
            return t.getDataLocalizacao();
        }

        if (field.getName().equals("local")) {
            return t.getLocal();
        }

        if (field.getName().equals("titulares")) {
            return t.getTitulares();
        }
        return null;
    }
}
