<%@page import="modelos.Projeto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/componentes/barraNav.jsp" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Agita Rural - Projetos</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/projetos.css">
</head>

<%
    List<Projeto> projetos = (List<Projeto>) request.getAttribute("projetos");
%>

<body>
	<div class="container">
		<h2>Projetos</h2>
			<div>
				<form class="form-filtro" action="<%= request.getContextPath() %>/projetos" method="get">
					<div class="div-primeira">
						<label for="titulo">Nome do projeto</label>
						<input type="text" id="titulo" name="nomeProjeto" value="${param.nomeProjeto}" autocomplete="off">
					</div>
					<div>
						<button type="submit">Filtrar</button>
					</div>
				</form>
			</div>
			<div class="card-container">
				<% if (projetos != null && !projetos.isEmpty()) {%>
					<% for (Projeto projeto : projetos) {%>
						<div class="card">
				            <h3><%= projeto.getNome() %></h3>
				            <p><%= projeto.getSobre() %></p>
				            <a href="<%= request.getContextPath()%>/projeto?id=<%= projeto.getId() %>" class="button">Ver detalhes</a>
				        </div>
					<% } %>
				<% } %>
			</div>
		</div>
</body>
</html>