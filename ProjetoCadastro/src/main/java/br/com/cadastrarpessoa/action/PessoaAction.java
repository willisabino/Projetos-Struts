package br.com.cadastrarpessoa.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.cadastrarpessoa.form.PessoaForm;
import br.com.cadastrarpessoa.service.PessoaService;
import br.com.cadastrarpessoa.vo.Pessoa;

public class PessoaAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		PessoaForm pessoaForm = (PessoaForm) form;
		PessoaService pessoaService = new PessoaService();
		ArrayList<Pessoa> listaPessoa = new ArrayList<>();
		
		if(pessoaForm.getAcao().equals("Inserir")) {
			
			pessoaService.inserirPessoas(pessoaForm.getNome(), pessoaForm.getIdade(), pessoaForm.getSexo());
			
		}else if(pessoaForm.getAcao().equals("Alterar")) {
			
			pessoaService.alterarCadastro(pessoaForm.getId(), pessoaForm.getNome(), pessoaForm.getIdade(), pessoaForm.getSexo());
			
		}else if(pessoaForm.getAcao().equals("Limpar")) {
			
			response.sendRedirect("/cadastroPessoa");
			
		}else if(!(pessoaForm.getAlterar().equals(null))) {
			
			Pessoa cadastro = new Pessoa();
			
			System.out.println("Estou na Alterar");
			cadastro = pessoaService.buscaPessoaPeloId(pessoaForm.getAlterar());
			request.setAttribute("cadastro", cadastro);
			
		}else if(!(pessoaForm.getEditar().equals(null))) {
			
			pessoaService.removeCadastro(pessoaForm.getEditar());
			System.out.println("oi Deletar");
			
		}
		System.out.println(pessoaForm.getEditar());
		
		pessoaForm.setAcao("");
		pessoaForm.setAlterar(null);
		pessoaForm.setEditar(null);
		
		listaPessoa = pessoaService.chamaListaPessoaService();
		request.setAttribute("listaPessoa", listaPessoa);
		
		
		ActionForward fw = mapping.getInputForward();
		fw = mapping.findForward("success");
		
		return fw;
	}
	
}
