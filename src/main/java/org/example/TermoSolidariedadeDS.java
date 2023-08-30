package org.example;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import java.util.Iterator;
import java.util.List;

public class TermoSolidariedadeDS implements JRDataSource {

    private TermoVO cursor;
    private Iterator<TermoVO> iterator;

    public TermoSolidariedadeDS(List<TermoVO> termos) {
        iterator = termos.iterator();
    }

    @Override
    public boolean next() throws JRException {
        return iterator.hasNext();
    }

    @Override
    public Object getFieldValue(JRField field) throws JRException {
        if ( next() ) {
            this.cursor = this.iterator.next();
            TermoVO t = this.cursor;

            if (field.getName().equals("conta")) {
                return t.getConta();
            }

            if (field.getName().equals("dataLocalizacao")) {
                return t.getDataLocalizacao();
            }

            if (field.getName().equals("local")) {
                return t.getLocal();
            }

            if (field.getName().equals("cpf")) {
                return t.getCpf();
            }
        }
        return null;
    }
}
