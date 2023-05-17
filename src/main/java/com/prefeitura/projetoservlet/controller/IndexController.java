package com.prefeitura.projetoservlet.controller;

import com.prefeitura.projetoservlet.model.HorarioTrabalho;
import com.prefeitura.projetoservlet.model.Marcacoes;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/index", ""})
public class IndexController extends HttpServlet {

    ArrayList<Marcacoes> listMarcacoes;
    ArrayList<HorarioTrabalho> listHorarioTrabalho;

    @Override
    public void init() {
        listMarcacoes = MarcacaoController.marcacoesFeitas;
        listHorarioTrabalho = HorarioTrabalhoController.tabelaHorarioTrabalho;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.equals("/index")) {
            tabelas(request, response);
        } else if (action.equals("")) {
            tabelas(request, response);
        }
    }

    public static void realizarSubtracao(List<HorarioTrabalho> tabela1, List<Marcacoes> tabela2, List<String> horaExtra, List<String> atraso) {
        for (HorarioTrabalho horarioTrabalho : tabela1) {
            LocalTime inicioTabela1 = LocalTime.parse(horarioTrabalho.getEntrada(), DateTimeFormatter.ofPattern("HH:mm"));
            LocalTime fimTabela1 = LocalTime.parse(horarioTrabalho.getSaida(), DateTimeFormatter.ofPattern("HH:mm"));

            for (Marcacoes marcacoes : tabela2) {
                LocalTime inicioTabela2 = LocalTime.parse(marcacoes.getEntrada(), DateTimeFormatter.ofPattern("HH:mm"));
                LocalTime fimTabela2 = LocalTime.parse(marcacoes.getSaida(), DateTimeFormatter.ofPattern("HH:mm"));
                
                 if (inicioTabela2.isBefore(inicioTabela1) && fimTabela2.isAfter(fimTabela1) && fimTabela2.isAfter(inicioTabela1)) {
                    horaExtra.add(inicioTabela2.toString() + " às " + inicioTabela1.toString());    
                    horaExtra.add(fimTabela1.toString() + " às " + fimTabela2.toString());
                    
                  
                } else if (inicioTabela2.isAfter(inicioTabela1) && fimTabela2.isBefore(fimTabela1) && fimTabela2.isBefore(inicioTabela1)) {
                    atraso.add(inicioTabela1.toString() + " às " + inicioTabela2.toString());
                    atraso.add(inicioTabela2.toString() + " às " + fimTabela2.toString());
                    atraso.add(fimTabela2.toString() + " às " + fimTabela1.toString());
                } else if (inicioTabela2.isBefore(inicioTabela1) && fimTabela2.isAfter(fimTabela1)) {
                    horaExtra.add(fimTabela1.toString() + " às " + fimTabela2.toString());
                    atraso.add(inicioTabela1.toString() + " às " + inicioTabela2.toString());

                }  else if (inicioTabela2.isBefore(inicioTabela1) && fimTabela2.isBefore(fimTabela1)) {
                    horaExtra.add(inicioTabela2.toString() + " às " + inicioTabela1.toString());
                    atraso.add(fimTabela2.toString() + " às " + fimTabela1.toString());
                } else if (inicioTabela2.isAfter(inicioTabela1) && fimTabela2.isAfter(fimTabela1)) {
                    horaExtra.add(fimTabela1.toString() + " às " + fimTabela2.toString());
                    atraso.add(inicioTabela1.toString() + " às " + inicioTabela2.toString());
                } else if (inicioTabela2.isAfter(inicioTabela1) && fimTabela2.isBefore(fimTabela1)) {
                    atraso.add(inicioTabela1.toString() + " às " + inicioTabela2.toString());
                    atraso.add(fimTabela2.toString() + " às " + fimTabela1.toString());
                } else if (inicioTabela2.isBefore(inicioTabela1) && fimTabela2.isAfter(fimTabela1)) {
                    horaExtra.add(inicioTabela2.toString() + " às " + inicioTabela1.toString());
                    horaExtra.add(fimTabela1.toString() + " às " + fimTabela2.toString());
                } else if (inicioTabela2.isBefore(inicioTabela1)) {
                    horaExtra.add(inicioTabela2.toString() + " às " + inicioTabela1.toString());
                } else if (fimTabela2.isAfter(fimTabela1)) {
                    horaExtra.add(fimTabela1.toString() + " às " + fimTabela2.toString());
                } else if (inicioTabela2.isAfter(inicioTabela1)) {
                    atraso.add(inicioTabela1.toString() + " às " + inicioTabela2.toString());
                } else if (fimTabela2.isBefore(fimTabela1)) {
                    atraso.add(fimTabela2.toString() + " às " + fimTabela1.toString());
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void tabelas(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("marcacao", listMarcacoes);
        request.setAttribute("horario", listHorarioTrabalho);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);

    }

}
