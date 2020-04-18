package br.com.stholen.exception;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception {
	
	private List<String> mensagens;
	
	public BusinessException() {
		super();
		mensagens = new ArrayList<String>();
	}
	
	public BusinessException(String mensagem) {
		super(mensagem);
		mensagens = new ArrayList<String>();
		mensagens.add(mensagem);
	}

	public List<String> getMensagens() {
		return mensagens;
	}

	public void addMessage(String mensagem) {
		this.mensagens.add(mensagem);
	}
	
}
