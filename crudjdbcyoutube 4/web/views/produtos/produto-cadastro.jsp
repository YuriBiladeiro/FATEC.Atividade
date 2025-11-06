<%-- 
    Document   : produto-cadastro
    Created on : 21 de set. de 2025, 15:11:54
    Author     : yurirossiguicho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manutenção de Produtos</title>
        <link rel="stylesheet" type="text/css" href="././estilos.css">
    </head>
    <body>
        <form action="${produto == null ? 'novo' : 'update'}" method="post">
            
            <input type="hidden" name="idProduto" value="${produto.getIdProduto() }" >
            Descrição: <input type="text" name="nomeProduto" value="${produto.getNomeProduto()}">
            Quantidade: <input type="text" name="qtdProduto" value="${produto.getQtdProduto()}">
            Valor: <input type="text" name="valorProduto" value="${produto.getValorProduto()}">
            
            <input type="submit" value="Salvar">
            
            <input type="button" value="Cancelar" onclick="window.location.href='listar';" />
            
        </form>
    </body>
</html>
