package org.example;

import java.io.Serializable;
import java.util.Date;

public class TermoVO implements Serializable {

    private String conta = "";
    private Date dataLocalizacao;
    private String local = "";
    private String cpf;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
