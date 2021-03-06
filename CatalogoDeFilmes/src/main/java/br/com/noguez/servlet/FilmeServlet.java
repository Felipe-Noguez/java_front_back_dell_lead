package br.com.noguez.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.noguez.modelo.Filme;

@WebServlet("/filme")
public class FilmeServlet  extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Filme coringa = new Filme("Coringa", "Drama", 2019);
		Filme matrix = new Filme("Matrix", "A??o", 1991);
		Filme forestGump = new Filme("Forest Gump", "Drama", 1994);
		
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		
		filmes.add(coringa);
		filmes.add(matrix);
		filmes.add(forestGump);
		
		String genero = req.getParameter("genero");		
		
		ArrayList<Filme> listaFiltrada = filmes.stream()
				.filter(filme -> filme.getGenero().toUpperCase().equals(genero.toUpperCase()))
				.collect(Collectors.toCollection(ArrayList::new));
		
		req.setAttribute("listaFiltrada", listaFiltrada);
		
		RequestDispatcher dispacther = req.getRequestDispatcher("/infofilme.jsp");
		
		dispacther.forward(req, resp);
		
	}
	
	
}
