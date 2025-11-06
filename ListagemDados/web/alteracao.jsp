<%@page import= "VO.Produto" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alteração de dados</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <%
            Produto p = (Produto) request.getAttribute("produto");

        %>

        <form name="frm" method="post" action="ProdutoController?operacao=4">
            <input type="hidden" name="id" value="<%=p.getId()%>">
            Nome <input type="text" name="nome" value="<%=p.getNome()%>">
            <br><br>
            Valor <input type="text" name="valor" value="<%=p.getValor()%>">
            <br><br>
            <input type="submit" value="Alterar">
        </form>
    </body>
</html>
