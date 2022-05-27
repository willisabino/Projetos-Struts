package br.com.cadastrarpessoa.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.cadastrarpessoa.factory.ConnectionFactory;
import br.com.cadastrarpessoa.vo.Pessoa;

public class PessoaDao {

	public void inserirCadastro(Pessoa pessoa) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO tb_ficha");
		sb.append("(nome, idade, dataCadastro, cod_sexo)");
		sb.append(" VALUES (?, ?, ?, ?)");
		
		String sql = sb.toString();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, pessoa.getNome());
			pstm.setInt(2, pessoa.getIdade());
			pstm.setDate(3, new Date(pessoa.getDataCadastro().getTime()));
			pstm.setString(4, pessoa.getSexo());
			
			pstm.execute();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			try{
				if(pstm!=null){
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}


	public ArrayList<Pessoa> chamaListaPessoas(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM tb_ficha ");
		sb.append("INNER JOIN tb_sexo ");
		sb.append("ON tb_ficha.cod_sexo = tb_sexo.id ");
		sb.append("ORDER BY tb_ficha.id");
		
		String sql = sb.toString();
		
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery(); 
			
			while(rset.next()) {
				
				Pessoa pessoa = new Pessoa();
				
				pessoa.setId(rset.getInt("id"));
				pessoa.setNome(rset.getString("nome"));
				pessoa.setIdade(rset.getInt("idade"));
				pessoa.setSexo(rset.getString("tb_sexo.sexo"));
				pessoa.setDataCadastro(rset.getDate("dataCadastro"));
				pessoas.add(pessoa);
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			try {
				if(rset != null) {
					rset.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace(); 
			}
		}
		
		return pessoas;
	}


	public void editarCadastro(Pessoa pessoa) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE tb_ficha ");
		sb.append("SET nome = ?, idade = ?, ");
		sb.append("dataCadastro = ?, cod_sexo = ? ");
		sb.append("WHERE id = ?");
		
		String sql = sb.toString();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, pessoa.getNome());
			pstm.setInt(2, pessoa.getIdade());
			//pstm.setString(3, pessoa.getSexo());
			pstm.setDate(3, new Date(pessoa.getDataCadastro().getTime()));
			pstm.setString(4, pessoa.getSexo());
			
			pstm.setLong(5, pessoa.getId());
			
			pstm.execute();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	
	public void deletarCadastro(long id) {
		
		String sql = "DELETE FROM tb_ficha WHERE id = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setLong(1, id);
			
			pstm.execute();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				if(pstm != null) {
					
					pstm.close();
					
				}
				if(conn != null) {
					conn.close();
				}
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
		}
	}

	
	public Pessoa buscaPeloId(long id){
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM tb_ficha ");
		sb.append("INNER JOIN tb_sexo ");
		sb.append("ON tb_ficha.cod_sexo = tb_sexo.id ");
		sb.append("WHERE tb_ficha.id = ?");
		
		String sql = sb.toString();
		
		Pessoa pessoa = null;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setLong(1, id);
			
			rset = pstm.executeQuery(); 
			
			while(rset.next()) {
				
				pessoa = new Pessoa();
				
				pessoa.setId(rset.getLong("id"));
				pessoa.setNome(rset.getString("nome"));
				pessoa.setIdade(rset.getInt("idade"));
				pessoa.setSexo(rset.getString("tb_sexo.sexo"));
				pessoa.setDataCadastro(rset.getDate("dataCadastro"));
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			try {
				if(rset != null) {
					rset.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace(); 
			}
		}
		
		return pessoa;
	}
}
