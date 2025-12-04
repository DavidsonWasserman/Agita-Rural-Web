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

<body>
	<div class="container">
		<h2>Projetos</h2>
			<div>
				<form class="form-filtro">
					<div class="div-primeira">
						<label for="titulo">Nome do projeto</label>
						<input type="text" id="titulo">
					</div>
					<div>
						<button type="submit">Filtrar</button>
					</div>
				</form>
			</div>
			<div class="card-container">
				<div class="card">
		            <h3>Esporte na Rural</h3>
		            <p>Vários esportes dentro da Universidade!</p>
		            <a href="projeto.jsp?id=1" class="button">Ver detalhes</a>
		        </div>
			</div>
		</div>
</body>
</html>