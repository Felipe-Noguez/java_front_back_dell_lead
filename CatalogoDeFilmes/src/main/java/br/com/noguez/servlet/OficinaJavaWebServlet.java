package br.com.noguez.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.noguez.modelo.Filme;

@WebServlet("/oficina-filme")
public class OficinaJavaWebServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Filme coringa = new Filme("Coringa", "Drama", 2019);
		Filme matrix = new Filme("Matrix", "A??o", 1991);
		Filme forestGump = new Filme("Forest Gump", "Drama", 1994);
		
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		
		filmes.add(coringa);
		filmes.add(matrix);
		filmes.add(forestGump);
		
		String ano = req.getParameter("ano");
		Integer an = 0;
		
		resp.setContentType("text/HTML");
		PrintWriter out = resp.getWriter();
		
		out.println("<h2> Lista de Filmes, utilizando Servlet. </h2>");
		
		out.println("<ol>");
		filmes.stream().filter(filme -> filme.getAno() >= an).forEach(filme -> {
			out.println(String.format("<li>Nome: %s", filme.getNome()));
			out.println(String.format("G?nero: %s", filme.getGenero()));
			out.println(String.format("Ano: %s </li>", filme.getAno()));
		});
		out.println("</ol>");
		out.close();
	}

}
