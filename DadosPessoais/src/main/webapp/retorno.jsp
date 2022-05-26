<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>

<h1>Olá! Esses são seus dados!</h1>

<p>Nome: <b:write name="valoresForm" property="nome"/></p>
<p>Idade: <b:write name="valoresForm" property="idade"/></p>
<p>Endereço: <b:write name="valoresForm" property="endereco"/></p>
<p>Telefone: <b:write name="valoresForm" property="telefone"/></p>