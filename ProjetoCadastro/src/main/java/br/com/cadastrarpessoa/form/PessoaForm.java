package br.com.cadastrarpessoa.form;

import java.util.Date;

import org.apache.struts.action.ActionForm;

public class PessoaForm extends ActionForm{

	private long id;
	private String nome;
	private int idade;
	private String sexo;
	private Date dataCadastro;
	private String acao;
	private String alterar;
	private String editar;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public String getAlterar() {
		return alterar;
	}
	public void setAlterar(String alterar) {
		this.alterar = alterar;
	}
	public String getEditar() {
		return editar;
	}
	public void setEditar(String editar) {
		this.editar = editar;
	}
}
