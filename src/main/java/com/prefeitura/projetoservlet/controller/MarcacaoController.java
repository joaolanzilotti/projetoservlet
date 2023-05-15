package com.prefeitura.projetoservlet.controller;

import com.prefeitura.projetoservlet.model.DAO;
import com.prefeitura.projetoservlet.model.HorarioTrabalho;
import com.prefeitura.projetoservlet.model.Marcacoes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/insert", "/marcacao", "/select", "/update", "/delete"})
public class MarcacaoController extends HttpServlet {

    DAO dao = new DAO();
    public static ArrayList<Marcacoes> marcacoesFeitas = new ArrayList<>();

    public MarcacaoController() {
        super();
    }

    @Override
    public void init() {
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
        //ArrayList<Marcacoes> listMarcacoes = dao.listarMarcacoes();
        ArrayList<Marcacoes> listMarcacoes = marcacoesFeitas;

        //Encaminhar a Lista ao Documento index.jsp
        request.setAttribute("marcacao", listMarcacoes);
        RequestDispatcher rd = request.getRequestDispatcher("marcacao.jsp");
        rd.forward(request, response);

    }

    protected void novaMarcacao(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Marcacoes marcacao = new Marcacoes();

        //Recebendo os Valores nos Atributos
        if (marcacoesFeitas.isEmpty()) {
            marcacao.setId("1");
        } else if (!marcacoesFeitas.isEmpty()) {
            Marcacoes ultimoIndiceMarcacoes = marcacoesFeitas.get(marcacoesFeitas.size() - 1);
            int resultadoId = Integer.valueOf(ultimoIndiceMarcacoes.getId()) + 1;

            marcacao.setId(String.valueOf(resultadoId));
        }
        marcacao.setEntrada(request.getParameter("entrada"));
        marcacao.setSaida(request.getParameter("saida"));
        System.out.println("ID AQUI" + marcacao.getId());

        //Inserir Ponto
        //dao.insertMarcacao(marcacao);
        marcacoesFeitas.add(marcacao);

        response.sendRedirect("marcacao");
    }

    protected void listarMarcacoes(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Marcacoes marcacao = new Marcacoes();

        marcacao.setId(request.getParameter("id"));

        for (Marcacoes m : marcacoesFeitas) {
            if (m.getId().equals(marcacao.getId())) {
                request.setAttribute("id", m.getId());
                request.setAttribute("entrada", m.getEntrada());
                request.setAttribute("saida", m.getSaida());
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher("editarMarcacoes.jsp");
        rd.forward(request, response);
    }

    protected void editarMarcacao(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Marcacoes marcacao = new Marcacoes();
        marcacao.setId(request.getParameter("id"));

        for (Marcacoes m : marcacoesFeitas) {
            if (m.getId().equals(marcacao.getId())) {

                m.setId(request.getParameter("id"));
                m.setEntrada(request.getParameter("entrada"));
                m.setSaida(request.getParameter("saida"));
                marcacoesFeitas.set(marcacoesFeitas.indexOf(m), m);
            }
        }

        response.sendRedirect("marcacao");

    }

    protected void removerMarcacao(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ConcurrentModificationException {
        Marcacoes marcacao = new Marcacoes();
        marcacao.setId(request.getParameter("id"));
        Iterator<Marcacoes> iterator = marcacoesFeitas.iterator();
        while (iterator.hasNext()) {
            Marcacoes m = iterator.next();
            if (m.getId().equals(marcacao.getId())) {
                iterator.remove();
            }
        }

        response.sendRedirect("marcacao");

    }

}
