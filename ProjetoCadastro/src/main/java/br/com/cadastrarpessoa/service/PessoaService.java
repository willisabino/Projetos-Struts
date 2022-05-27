package br.com.cadastrarpessoa.service;

import java.util.ArrayList;
import java.util.Date;

import br.com.cadastrarpessoa.dao.PessoaDao;
import br.com.cadastrarpessoa.vo.Pessoa;

public class PessoaService {

private PessoaDao pessoaDao = new PessoaDao();
	
	public ArrayList<Pessoa> chamaListaPessoaService() {
		
		return pessoaDao.chamaListaPessoas();
		
	}

	public void inserirPessoas(String nome, int idade, String sexo) {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setIdade(idade);
		pessoa.setSexo(sexo);
		pessoa.setDataCadastro(new Date());
		
		pessoaDao.inserirCadastro(pessoa);
	}

	public void alterarCadastro(long id, String nome, int idade, String sexo) {
		
		Pessoa pessoa = new Pessoa();
		
		
		pessoa.setNome(nome);
		pessoa.setIdade(idade);
		pessoa.setSexo(sexo);
		pessoa.setDataCadastro(new Date());
		pessoa.setId(id);
		
		pessoaDao.editarCadastro(pessoa);
		
	}

	public void removeCadastro(String id) {
		
		pessoaDao.deletarCadastro(Long.parseLong(id));
		
	}

	public Pessoa buscaPessoaPeloId(String paramId) {
		
		return pessoaDao.buscaPeloId(Long.parseLong(paramId));
		
	}
}
