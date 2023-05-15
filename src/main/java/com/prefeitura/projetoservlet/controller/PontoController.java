package com.prefeitura.projetoservlet.controller;

import static com.prefeitura.projetoservlet.controller.MarcacaoController.marcacoesFeitas;
import com.prefeitura.projetoservlet.model.DAO;
import com.prefeitura.projetoservlet.model.HorarioTrabalho;
import com.prefeitura.projetoservlet.model.Marcacoes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
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
    public static ArrayList<HorarioTrabalho> tabelaHorarioTrabalho = new ArrayList<>();

    public PontoController() {
        super();
    }

    @Override
    public void init() {
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
        //ArrayList<HorarioTrabalho> listHorariosTrabalhados = dao.listarHorarioTrabalho();
        ArrayList<HorarioTrabalho> listHorariosTrabalhados = tabelaHorarioTrabalho;

        //Encaminhar a Lista ao Documento index.jsp
        request.setAttribute("horario", listHorariosTrabalhados);
        RequestDispatcher rd = request.getRequestDispatcher("ponto.jsp");
        rd.forward(request, response);

    }

    protected void novoHorarioTrabalho(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HorarioTrabalho horario = new HorarioTrabalho();
        //Recebendo os Valores nos Atributos
        if (tabelaHorarioTrabalho.isEmpty()) {
            horario.setId("1");
        } else if (!tabelaHorarioTrabalho.isEmpty()) {
            HorarioTrabalho ultimoIndiceHorarioTrabalho = tabelaHorarioTrabalho.get(tabelaHorarioTrabalho.size() - 1);
            int resultadoId = Integer.valueOf(ultimoIndiceHorarioTrabalho.getId()) + 1;

            horario.setId(String.valueOf(resultadoId));
        }

        //Recebendo os Valores nos Atributos
        horario.setEntrada(request.getParameter("entrada"));
        horario.setSaida(request.getParameter("saida"));

        //Inserir Ponto
        // dao.insertHorarioTrabalho(horario);
        tabelaHorarioTrabalho.add(horario);
        response.sendRedirect("ponto");
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

    protected void editarContato(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
        response.sendRedirect("ponto");

    }

    protected void removerContato(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HorarioTrabalho horario = new HorarioTrabalho();

        horario.setId(request.getParameter("id"));
        Iterator<HorarioTrabalho> iterator = tabelaHorarioTrabalho.iterator();
        while (iterator.hasNext()) {
            HorarioTrabalho h = iterator.next();
            if (h.getId().equals(horario.getId())) {
                iterator.remove();
            }
        }

        response.sendRedirect("ponto");

    }

}
