<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>

<h:form action="/dadosPessoais">

	<label>Informe seu Nome</label>
	<br>
	<h:text property="nome"/>
	<br>

	<label>Digite Sua Idade</label>
	<br>
	<h:text property="idade">Idade</h:text>
	<br>

	<label>Informe Seu Endereço</label>
	<br>
	<h:text property="endereco">Endereço</h:text>
	<br>

	<label>Digite Seu Telefone</label>
	<br>
	<h:text property="telefone">Telefone</h:text>
	<br>
	<h:submit value="Enviar"/>

</h:form>