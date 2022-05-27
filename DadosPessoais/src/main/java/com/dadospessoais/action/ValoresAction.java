package com.dadospessoais.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dadospessoais.form.ValoresForm;

public class ValoresAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ValoresForm valoresForm = (ValoresForm) form;
		ActionForward fw = mapping.getInputForward();
		
		fw = mapping.findForward("success");
		
		return fw;
	}

}
