package br.com.cwi.aula5;

import br.com.cwi.aula5.entity.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author vinicius.ambrosi
 */
@WebServlet(name = "pessoa", urlPatterns = ("/pessoa"))
public class PessoaServlet extends HttpServlet {

    List<Pessoa> pessoas = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        try (final PrintWriter out = resp.getWriter();) {
            for (Pessoa pessoa : pessoas) {
                out.append(pessoa.getNome()).append("</br>");
                out.append(String.valueOf(pessoa.getIdade())).append("</br>");
                out.append(pessoa.getSexo()).append("</br>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        int idade = Integer.parseInt(req.getParameter("idade"));
        String sexo = req.getParameter("sexo");
        pessoas.add(new Pessoa(nome, idade, sexo));
    }
//            nomes.forEach(s -> {
//                writer.append(s).append("<br/>");
//            });
}

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        process(request,response);
//    }
//    
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        process(request,response);
//    }
//    
//    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        try(final PrintWriter out = response.getWriter();){
//            out.append(request.getParameter("pessoa.nome"));
//        }
//    }
//response.sendRedirect("http://www.google.com.br");
//        response.setContentType("text/html");
//        try (final PrintWriter out = response.getWriter();) {
//            out.append("<!DOCTYPE html>");
//            out.append("<html>");
//            out.append("<head>");
//            out.append("<title>Java - aula5</title>");
//            out.append("<meta charset=\"UTF-8\">");
//            out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
//            out.append("</head>");
//            out.append("<body>");
//            out.append("<h1>Pessoa</h1>");
//            out.append("</body>");
//            out.append("</html>");
//        }
