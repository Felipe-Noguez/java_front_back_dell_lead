<%@page import= "br.com.noguez.modelo.Filme" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listass de Filmes</title>
</head>
<body>
	<h2>Lista de Filmes.</h2>
	<ol>
		<%
			ArrayList<Filme> list = new ArrayList<Filme>();
			list = (ArrayList) request.getAttribute("listaFiltrada");
			
			for (Filme filme: list){
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