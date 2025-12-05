<%@page import="modelos.Acao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/componentes/barraNav.jsp" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Agita Rural - Ações</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/acoes.css">
</head>

<%
    List<Acao> acoes = (List<Acao>) request.getAttribute("acoes");    
%>

<body>
    <div class="container">
        <h2>Ações</h2>

        <div>
            <form class="form-filtro" action="<%= request.getContextPath() %>/acoes" method="get">

                <!-- Nome da ação -->
                <div>
                    <label for="titulo">Nome da ação</label>
                    <input type="text" id="titulo" name="nomeAcao" value="${param.nomeAcao}" autocomplete="off">
                </div>

                <!-- Sem taxas -->
                <div>
                    <label class="checkbox-label">
                        <input type="checkbox" name="semTaxa" value="true"
                               ${param.semTaxa == 'true' ? 'checked' : ''}>
                        <span>Sem taxas</span>
                    </label>
                </div>

                <!-- Status -->
                <div class="status-checkbox">
                    <span>Status</span>

                    <div class="escolhas-checkbox">

                        <label class="checkbox-label">
                            <input type="checkbox" name="status" value="ATIVO"
                                   ${param.status == 'ATIVO' ? 'checked' : ''}>
                            <span>Ativo</span>
                        </label>

                        <label class="checkbox-label">
                            <input type="checkbox" name="status" value="PAUSADO"
                                   ${param.status == 'PAUSADO' ? 'checked' : ''}>
                            <span>Pendente</span>
                        </label>

                        <label class="checkbox-label">
                            <input type="checkbox" name="status" value="DESCONTINUADO"
                                   ${param.status == 'DESCONTINUADO' ? 'checked' : ''}>
                            <span>Descontinuado</span>
                        </label>

                    </div>
                </div>

                <div>
                    <button type="submit">Filtrar</button>
                </div>

            </form>
        </div>

        <!-- Cards -->
        <div class="card-container">
            <% if (acoes != null && !acoes.isEmpty()) { %>
                <% for (Acao acao : acoes) { %>
                    <div class="card">
                        <h3><%= acao.getNome() %></h3>
                        <p><%= acao.getSobre() %></p>
                        <p>Inicio: <%= acao.getDataInicioFormatada() %> | Fim: <%= acao.getDataFimFormatada() %></p>
                        <a href="<%= request.getContextPath()%>/acao?id=<%= acao.getId() %>" class="button">Ver detalhes</a>
                    </div>
                <% } %>
            <% } %>
        </div>

    </div>
</body>
</html>
