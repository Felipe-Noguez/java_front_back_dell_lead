<%@page import= "br.com.noguez.modelo.Filme" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Info Filme</title>
</head>
<body>
	<h2>Lista de Filmes.</h2>
	<ol>
		<%
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		filmes = (ArrayList) request.getAttribute("listaFiltrada");

		for (Filme filme : filmes) {
		%>
		<li>
			<%
			out.println("Nome: " + filme.getNome());
			out.println("Gen?ro: " + filme.getGenero());
			out.println("Ano: " + filme.getAno());
			%>
		</li>
		<%
		}
		%>
	</ol>

</body>
</html>