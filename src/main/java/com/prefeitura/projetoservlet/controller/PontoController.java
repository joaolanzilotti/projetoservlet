package com.prefeitura.projetoservlet.controller;

import com.prefeitura.projetoservlet.model.Horario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joaoferretti
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller", "/insert", "/ponto"})
public class PontoController extends HttpServlet {

    Horario horario = new Horario();
    ArrayList<Horario> tabelaHorarioTrabalho;
    ArrayList<Horario> marcacoesFeitas;
    ArrayList<Horario> atraso;
    ArrayList<Horario> horaExtra;

    public PontoController() {
        super();
    }
    
    

    @Override
    public void init() {
        tabelaHorarioTrabalho = new ArrayList<>();
        marcacoesFeitas = new ArrayList<>();
        atraso = new ArrayList<>();
        horaExtra = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        if(action.equals("/ponto")){
            horarios(request, response);
        }else if (action.equals("/insert")) {
            novoHorarioTrabalho(request, response);
        }
        else{
            response.sendRedirect(request.getContextPath()+"index.html");
        }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void horarios(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Horario> listHorariosTrabalhados = tabelaHorarioTrabalho;
        
        //Encaminhar a Lista ao Documento index.jsp
        request.setAttribute("horario", listHorariosTrabalhados);
        RequestDispatcher rd = request.getRequestDispatcher("ponto.jsp");
        rd.forward(request, response);
       
    }

    protected void novoHorarioTrabalho(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        //Teste de Recebimento
        System.out.println(request.getParameter("entrada"));
        System.out.println(request.getParameter("saida"));

        //Recebendo os Valores nos Atributos
        horario.setEntrada(request.getParameter("entrada"));
        horario.setSaida(request.getParameter("saida"));

        //Inserir Ponto
        tabelaHorarioTrabalho.add(horario);
        response.sendRedirect("ponto");
    }

}
