<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="modelos.Acao, modelos.Unidade, java.util.*" %>

<%@ include file="/componentes/barraNav.jsp" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Editar Ação</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/dashboard.css">
</head>

<body>

<%
    Acao acao = (Acao) request.getAttribute("acao");
    List<Unidade> unidades = (List<Unidade>) request.getAttribute("unidades");
%>

<section style="background:#004d26; color:white; padding:30px; text-align:center;">
    <h1>Editar Ação: <%= acao.getNome() %></h1>
</section>

<div class="container">

    <form action="<%= request.getContextPath() %>/admin/atualizarAcao" method="post" class="form-box">

        <input type="hidden" name="id" value="<%= acao.getId() %>">

        <!-- DESCRIÇÃO -->
        <label>Descrição:</label>
        <textarea name="sobre" required><%= acao.getSobre() %></textarea>

        <!-- PÚBLICO ALVO -->
        <label>Público-alvo:</label>
        <input type="text" name="publicoAlvo" value="<%= acao.getPublicoAlvo() %>" required>

        <!-- LOCALIZAÇÃO -->
        <h3>Localização</h3>

        <label>Nome do local:</label>
        <input type="text" name="nomeLocal" value="<%= acao.getLocalizacao().getNome() %>" required>

        <label>Endereço:</label>
        <input type="text" name="endereco" value="<%= acao.getLocalizacao().getEndereco() %>" required>

        <label>Ponto de referência:</label>
        <input type="text" name="pontoRef"
               value="<%= acao.getLocalizacao().getPontoDeReferencia() != null
                        ? acao.getLocalizacao().getPontoDeReferencia()
                        : "" %>">

        <!-- TAXA -->
        <h3>Taxa</h3>

        <div class="criar-row taxa-row">
    		<label for="taxa">Possui Taxa?</label>
    			<div class="checkbox-wrapper">
        			<input type="checkbox" id="taxa" name="possuiTaxa" <%= acao.getTaxa() ? "checked" : "" %> />
        			<span>Sim</span>
    			</div>
		</div>



        <label>Preço:</label>
        <input type="text" name="preco"
               value="<%= acao.getPreco() != null ? acao.getPreco() : "" %>">

        <!-- UNIDADE -->
        <h3>Unidade responsável</h3>

        <select name="unidadeId" required>
            <% for (Unidade u : unidades) { %>
                <option value="<%= u.getId() %>"
                    <%= u.getId() == acao.getUnidade().getId() ? "selected" : "" %>>
                    <%= u.getNome() %> – <%= u.getTipo() %>
                </option>
            <% } %>
        </select>

        <a href="<%= request.getContextPath() %>/admin/encerrarAcao?id=<%= acao.getId() %>"
		    class="btn btn-red"
   			style="margin-top: 10px; display: inline-block;"
   			onclick="return confirm('Tem certeza que deseja encerrar esta ação?')">
    		Encerrar ação
		</a>

        <button class="btn" type="submit">Salvar alterações</button>

    </form>

</div>

</body>
</html>
