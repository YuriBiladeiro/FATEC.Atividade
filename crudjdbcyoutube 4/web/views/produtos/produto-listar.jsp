<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Lista de Produtos</title>
    <link rel="stylesheet" type="text/css" href="../css/estilos.css">
</head>
<body>
    
    <jsp:include page="../../includes/menu.jsp" />
    
    <h2>Lista de Produtos</h2>
    
    <table border="1" cellspacing="0" cellpadding="5"> 
        <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Quantidade</th>
            <th>Valor</th>
        </tr>
        </thead>
        
        <tbody>
            
        <c:forEach var="produto" items="${listaProdutos}">
            <tr>
                <td>${produto.idProduto} </td>
                <td>${produto.nomeProduto} </td>
                <td>${produto.qtdProduto} </td>
                <td>${produto.valorProduto} </td>
                <td>
                    <a href="editar?id=${produto.idProduto} ">Editar</a>
                    <a href="excluir?id=${produto.idProduto}">Excluir</a> 
                </td>
             </tr>
             </c:forEach>
             
        </tbody>

    </table>
    
    <br>
    
    <a href="cadastro">Cadastrar Produto</a>
    
    <jsp:include page="../../includes/footer.jsp" />
    
    <h3>Os produtos são listados automaticamente!</h3> 
    
</body>
<html>
