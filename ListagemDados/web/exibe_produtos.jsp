<%@page import="java.util.List"%>
<%@page import="VO.Produto"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem</title>
    </head>
    <body>

        <%
            List produtos = (List) request.getAttribute("lista");
            if (produtos != null) {
                out.print("<center>Achados: " + produtos.size() + "</center><br><br><br>");
                out.print("<table width=\"50%\" border=\"1\" cellspacing=\"0\" align=\"center\">");
                for (int cont = 0; cont < produtos.size(); cont++) {
                    Produto p = new Produto();
                    p = (Produto) produtos.get(cont);
                    out.print("<tr>");
                    out.print("<td>" + p.getNome() + "</td>");
                    out.print("<td>" + "R$" + p.getValor() + "</td>");
                    out.print("<td><a href=\"ProdutoController?operacao=2&id="+p.getId()+"\">Excluir</a></td>");
                    out.print("<td><a href=\"ProdutoController?operacao=3&id="+p.getId()+"\">Alterar</a></td>");
                    out.print("</tr>");
                }
                out.print("</table>");
            }            
        %>

    </body>
</html>
