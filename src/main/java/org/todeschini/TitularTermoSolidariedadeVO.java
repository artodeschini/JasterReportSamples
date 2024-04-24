package org.todeschini;

import java.io.Serializable;

public class TitularTermoSolidariedadeVO implements Serializable {

    private String name;
    private String cpf;

    public TitularTermoSolidariedadeVO() {
        this.cpf = "";
    }

    public TitularTermoSolidariedadeVO(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
