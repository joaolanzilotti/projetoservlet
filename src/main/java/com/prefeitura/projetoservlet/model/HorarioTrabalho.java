package com.prefeitura.projetoservlet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HorarioTrabalho {

    private String id;
    private String entrada;
    private String saida;


}
