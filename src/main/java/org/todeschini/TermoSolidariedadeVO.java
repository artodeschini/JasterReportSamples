package org.todeschini;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TermoSolidariedadeVO implements Serializable {

    private String conta = "";
    private Date dataLocalizacao;
    private String local = "";

    private List<TitularTermoSolidariedadeVO> titulares = new ArrayList<>();

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Date getDataLocalizacao() {
        return dataLocalizacao;
    }

    public void setDataLocalizacao(Date dataLocalizacao) {
        this.dataLocalizacao = dataLocalizacao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public List<TitularTermoSolidariedadeVO> getTitulares() {
        return titulares;
    }

    public void setTitulares(List<TitularTermoSolidariedadeVO> titulares) {
        this.titulares = titulares;
    }
}
