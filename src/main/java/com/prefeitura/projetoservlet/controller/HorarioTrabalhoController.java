package com.prefeitura.projetoservlet.controller;

import com.prefeitura.projetoservlet.model.HorarioTrabalho;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/add", "/horariotrabalho", "/selectPonto", "/updatePonto", "/deletePonto"})
public class HorarioTrabalhoController extends HttpServlet {

    public static ArrayList<HorarioTrabalho> tabelaHorarioTrabalho = new ArrayList<>();

    public HorarioTrabalhoController() {
        super();
    }

    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.equals("/horariotrabalho")) {
            horarios(request, response);
        } else if (action.equals("/updatePonto")) {
            editarHorarioTrabalho(request, response);
        } else if (action.equals("/add")) {
            novoHorarioTrabalho(request, response);
        } else if (action.equals("/deletePonto")) {
            removerHorarioTrabalho(request, response);
        } else if (action.equals("/selectPonto")) {
            listarHorarios(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void horarios(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //ArrayList<HorarioTrabalho> listHorariosTrabalhados = dao.listarHorarioTrabalho();
        ArrayList<HorarioTrabalho> listHorariosTrabalhados = tabelaHorarioTrabalho;

        //Encaminhar a Lista ao Documento index.jsp
        request.setAttribute("horario", listHorariosTrabalhados);
        RequestDispatcher rd = request.getRequestDispatcher("horarioTrabalho.jsp");
        rd.forward(request, response);

    }

    protected void novoHorarioTrabalho(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HorarioTrabalho horario = new HorarioTrabalho();

        if (tabelaHorarioTrabalho.isEmpty()) {
            horario.setId("1");
        } else if (!tabelaHorarioTrabalho.isEmpty()) {
            HorarioTrabalho ultimoIndiceHorarioTrabalho = tabelaHorarioTrabalho.get(tabelaHorarioTrabalho.size() - 1);
            int resultadoId = Integer.valueOf(ultimoIndiceHorarioTrabalho.getId()) + 1;

            horario.setId(String.valueOf(resultadoId));
        }

        horario.setEntrada(request.getParameter("entrada"));
        horario.setSaida(request.getParameter("saida"));


        tabelaHorarioTrabalho.add(horario);
        response.sendRedirect("horariotrabalho");
    }

    protected void listarHorarios(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HorarioTrabalho horario = new HorarioTrabalho();

        horario.setId(request.getParameter("id"));

        for (HorarioTrabalho h : tabelaHorarioTrabalho) {
            if (h.getId().equals(horario.getId())) {
                request.setAttribute("id", h.getId());
                request.setAttribute("entrada", h.getEntrada());
                request.setAttribute("saida", h.getSaida());
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
        rd.forward(request, response);
    }

    protected void editarHorarioTrabalho(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HorarioTrabalho horario = new HorarioTrabalho();
        horario.setId(request.getParameter("id"));

        for (HorarioTrabalho h : tabelaHorarioTrabalho) {
            if (h.getId().equals(horario.getId())) {

                h.setId(request.getParameter("id"));
                h.setEntrada(request.getParameter("entrada"));
                h.setSaida(request.getParameter("saida"));
                tabelaHorarioTrabalho.set(tabelaHorarioTrabalho.indexOf(h), h);
            }
        }
        response.sendRedirect("horariotrabalho");

    }

    protected void removerHorarioTrabalho(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HorarioTrabalho horario = new HorarioTrabalho();

        horario.setId(request.getParameter("id"));
        Iterator<HorarioTrabalho> iterator = tabelaHorarioTrabalho.iterator();
        while (iterator.hasNext()) {
            HorarioTrabalho h = iterator.next();
            if (h.getId().equals(horario.getId())) {
                iterator.remove();
            }
        }

        response.sendRedirect("horariotrabalho");

    }

}
