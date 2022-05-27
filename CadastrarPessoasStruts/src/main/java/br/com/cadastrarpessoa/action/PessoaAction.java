package br.com.cadastrarpessoa.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.cadastrarpessoa.service.PessoaService;
import br.com.cadastrarpessoa.vo.Pessoa;

public class PessoaAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward fw = mapping.getInputForward();
		PessoaService pessoaService = new PessoaService();
		ArrayList<Pessoa> listaPessoas = new ArrayList<>();
		
		listaPessoas = pessoaService.chamaListaPessoaService();
		
		fw = mapping.findForward("success");
		
		return fw;
	}

}
