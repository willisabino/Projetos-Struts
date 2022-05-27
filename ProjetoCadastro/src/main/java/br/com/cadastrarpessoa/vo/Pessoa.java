package br.com.cadastrarpessoa.vo;

import java.util.Date;

public class Pessoa {
	
	private long id;
	private String nome;
	private int idade;
	private String sexo;
	private Date dataCadastro  = new java.sql.Date(System.currentTimeMillis());
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(id);
		sb.append(" ");
		sb.append(nome);
		sb.append(" ");
		sb.append(idade);
		sb.append(" ");
		sb.append(sexo);
		sb.append(" ");
		sb.append(dataCadastro);
		
		return sb.toString();
	}
	
	
	
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

	
}
