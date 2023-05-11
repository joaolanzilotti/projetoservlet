package com.prefeitura.projetoservlet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Horario {

    private String entrada;
    private String saida;

    public Horario() {
        super();
    }
    
    

    public Horario(String entrada, String saida) {
        super();
        this.entrada = entrada;
        this.saida = saida;
    }
    
    

}
