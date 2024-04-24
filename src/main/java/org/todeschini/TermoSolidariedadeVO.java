package org.todeschini;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TermoSolidariedadeVO implements Serializable {

    private String conta = "";
    private Date dataLocalizacao;
    private String local = "";

    private List<TitularTermoSolidariedadeVO> titulares = new ArrayList<>();
}

