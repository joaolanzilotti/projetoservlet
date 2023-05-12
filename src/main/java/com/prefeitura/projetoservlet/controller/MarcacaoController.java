/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.prefeitura.projetoservlet.controller;

import com.prefeitura.projetoservlet.model.DAO;
import com.prefeitura.projetoservlet.model.HorarioTrabalho;
import com.prefeitura.projetoservlet.model.Marcacoes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "Controller", urlPatterns = {"/Controller", "/insert", "/marcacao", "/select", "/update", "/delete"})
public class MarcacaoController extends HttpServlet {

    DAO dao = new DAO();
    Marcacoes marcacao = new Marcacoes();
    ArrayList<HorarioTrabalho> marcacoesFeitas;

    public MarcacaoController() {
        super();
    }

    @Override
    public void init() {
        marcacoesFeitas = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.equals("/marcacao")) {
            marcacoes(request, response);
        } else if (action.equals("/update")) {
            editarMarcacao(request, response);
        } else if (action.equals("/insert")) {
            novaMarcacao(request, response);
        } else if (action.equals("/delete")) {
            removerMarcacao(request, response);
        } else if (action.equals("/select")) {
            listarMarcacoes(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "index.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void marcacoes(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Marcacoes> listMarcacoes = dao.listarMarcacoes();

        //Encaminhar a Lista ao Documento index.jsp
        request.setAttribute("marcacao", listMarcacoes);
        RequestDispatcher rd = request.getRequestDispatcher("marcacao.jsp");
        rd.forward(request, response);

    }

    protected void novaMarcacao(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //Recebendo os Valores nos Atributos
        marcacao.setEntrada(request.getParameter("entrada"));
        marcacao.setSaida(request.getParameter("saida"));

        //Inserir Ponto
        dao.insertMarcacao(marcacao);
        response.sendRedirect("marcacao");
    }

    protected void listarMarcacoes(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        marcacao.setId(request.getParameter("id"));

        dao.selecionarMarcacoes(marcacao);

        request.setAttribute("id", marcacao.getId());
        request.setAttribute("entrada", marcacao.getEntrada());
        request.setAttribute("saida", marcacao.getSaida());

        RequestDispatcher rd = request.getRequestDispatcher("editarMarcacoes.jsp");
        rd.forward(request, response);
    }

    protected void editarMarcacao(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        marcacao.setId(request.getParameter("id"));
        marcacao.setEntrada(request.getParameter("entrada"));
        marcacao.setSaida(request.getParameter("saida"));
        dao.alterarMarcacao(marcacao);
        response.sendRedirect("marcacao");

    }

    protected void removerMarcacao(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String id = request.getParameter("id");
        marcacao.setId(id);
        dao.deletarMarcacao(marcacao);
        response.sendRedirect("marcacao");

    }

}
