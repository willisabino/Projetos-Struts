package info.java.tips.form;

import org.apache.struts.action.ActionForm;

public class HelloForm extends ActionForm{

		private String nome;

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		
}
