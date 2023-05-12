package com.prefeitura.projetoservlet.controller;

import com.prefeitura.projetoservlet.model.DAO;
import com.prefeitura.projetoservlet.model.HorarioTrabalho;
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
@WebServlet(urlPatterns = {"/add", "/ponto", "/selectPonto", "/updatePonto", "/deletePonto"})
public class PontoController extends HttpServlet {

    DAO dao = new DAO();
    HorarioTrabalho horario = new HorarioTrabalho();
    ArrayList<HorarioTrabalho> tabelaHorarioTrabalho;
    ArrayList<HorarioTrabalho> marcacoesFeitas;
    ArrayList<HorarioTrabalho> atraso;
    ArrayList<HorarioTrabalho> horaExtra;

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
        if (action.equals("/ponto")) {
            horarios(request, response);
        } else if (action.equals("/updatePonto")) {
            editarContato(request, response);
        } else if (action.equals("/add")) {
            novoHorarioTrabalho(request, response);
        } else if (action.equals("/deletePonto")) {
            removerContato(request, response);
        } else if (action.equals("/selectPonto")) {
            listarHorarios(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "index.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void horarios(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<HorarioTrabalho> listHorariosTrabalhados = dao.listarHorarioTrabalho();

        //Encaminhar a Lista ao Documento index.jsp
        request.setAttribute("horario", listHorariosTrabalhados);
        RequestDispatcher rd = request.getRequestDispatcher("ponto.jsp");
        rd.forward(request, response);

    }

    protected void novoHorarioTrabalho(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //Recebendo os Valores nos Atributos
        horario.setEntrada(request.getParameter("entrada"));
        horario.setSaida(request.getParameter("saida"));

        //Inserir Ponto
        dao.insertHorarioTrabalho(horario);
        response.sendRedirect("ponto");
    }

    protected void listarHorarios(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        horario.setId(request.getParameter("id"));

        dao.selecionarHorarioTrabalho(horario);

        request.setAttribute("id", horario.getId());
        request.setAttribute("entrada", horario.getEntrada());
        request.setAttribute("saida", horario.getSaida());

        RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
        rd.forward(request, response);
    }

    protected void editarContato(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        horario.setId(request.getParameter("id"));
        horario.setEntrada(request.getParameter("entrada"));
        horario.setSaida(request.getParameter("saida"));
        dao.alterarHorarioTrabalho(horario);
        response.sendRedirect("ponto");

    }

    protected void removerContato(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String id = request.getParameter("id");
        horario.setId(id);
        dao.deletarHorarioTrabalho(horario);
        response.sendRedirect("ponto");

    }

}
