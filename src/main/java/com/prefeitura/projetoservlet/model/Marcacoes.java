
package com.prefeitura.projetoservlet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Marcacoes {
    
    private String id;
    private String entrada;
    private String saida;

    public Marcacoes(String id) {
        this.id = id;
    }
    
    
    
}
