<%@ page contentType="text/html;charset=UTF-8" language="java" import="modelos.Acao, modelos.Unidade, java.util.*" %>

<%@ include file="/componentes/barraNav.jsp" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Ações cadastradas</title>

    <!-- CSS externo -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/lista.css">
</head>

<body>

<%
    List<Acao> acoes = (List<Acao>) request.getAttribute("acoes");
%>

<section class="header-section">
    <h1>Ações Cadastradas</h1>
</section>

<div class="container">

    <table class="tabela-acoes">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Público</th>
            <th>Status</th>
            <th>Unidade</th>
            <th>Ações</th>
        </tr>

        <% 
            if (acoes != null && !acoes.isEmpty()) {
                for (Acao acao : acoes) {
        %>

        <tr>
            <td><%= acao.getId() %></td>
            <td><%= acao.getNome() %></td>
            <td><%= acao.getPublicoAlvo() %></td>

            <td>
                <% if (acao.getDataFim() == null) { %>
                    <span class="status-ativo">ATIVO</span>
                <% } else { %>
                    <span class="status-encerrado">ENCERRADO</span>
                <% } %>
            </td>

            <td>
                <%= acao.getUnidade() != null ? acao.getUnidade().getNome() : "N/A" %>
            </td>

            <td class="acoes-btns">
                <a href="<%= request.getContextPath() %>/admin/acaoMod?id=<%= acao.getId() %>" 
                   class="btn-editar">Editar</a>

                <% if (acao.getDataFim() == null) { %>
                <a href="<%= request.getContextPath() %>/admin/encerrarAcao?id=<%= acao.getId() %>" 
                   class="btn-encerrar">Encerrar</a>
                <% } %>
            </td>
        </tr>

        <% 
                }
            } else {
        %>
            <tr>
                <td colspan="6" class="nenhuma-acao">
                    Nenhuma ação cadastrada.
                </td>
            </tr>
        <% } %>
    </table>

</div>

</body>
</html>
