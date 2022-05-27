<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Pessoas</title>
<link rel="stylesheet" href="estilo.css">
</head>
<body>

<h:form action="/cadastroPessoa">

		<h1>Cadastro de Pessoas</h1>

		<p> <!-- hidden="hidden" -->
			<label for="id">ID</label>
			<input type="text" name="id" id="id" value="${ cadastro.id }">
		</p>
		<p>
			<label for="nome">Nome</label> 
			<input type="text" name="nome" id="nome" value="${ cadastro.nome }">
		</p>
		<p>
			<label for="nome">Idade</label> 
			<input type="text" name="idade" id="idade" required min="0" max="99" value="${ cadastro.idade }">
		</p>
		<p>
			<label for="sexo">Sexo</label> <select name="sexo" id="sexo">
				<option>Selecione um Sexo:</option>
				<option value="1">Masculino</option>
				<option value="2">Feminino</option>
			</select>
		</p>
		<p>
		
			<!--  <button value="Inserir" id="inserir" name="acao">Inserir</button> -->
			<input type="submit" value="Inserir" id="inserir" name="acao">  
			<input type="submit" value="Alterar" id="alterar" name="acao"> 
			<input type="submit" value="Limpar" id="limpar" name="acao">
		
		</p>

</h:form>

<h:form action="/cadastroPessoa">

<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Idade</th>
					<th>Sexo</th>
					<th>Data Cadastro</th>
					<th>Alterar</th>
					<th>Editar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ listaPessoa }" var="listaPessoas">

					<tr>
						<td>${ listaPessoas.id }</td>
						<td>${ listaPessoas.nome }</td>
						<td>${ listaPessoas.idade }</td>
						<td>${ listaPessoas.sexo }</td>
						<td><fmt:formatDate value="${ listaPessoas.dataCadastro }" pattern="dd/MM/yyy" /></td>
						<td><button value="${ listaPessoas.id }" id="alterar" name="alterar">O</button></td>

						<td>
<%-- 						<a href="removePessoaServlet?id=${listaPessoas.id}" onclick="return confirm('Tem certeza que deseja apagar o contato ${ listaPessoas.nome }?')">X</a> --%>
<%-- 						<input type="submit" value="X" value="${ listaPessoas.id }" name="acao"> --%>
						<button value="${ listaPessoas.id }" id="editar" name="editar">X</button></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>

</h:form>

</body>
</html>