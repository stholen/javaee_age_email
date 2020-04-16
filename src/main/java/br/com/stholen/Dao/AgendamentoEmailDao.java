package br.com.stholen.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class AgendamentoEmailDao {

	public List<String> listarAgendamentoEmail(){
		List<String> emails = new ArrayList<String>();
		emails.add("email1@servidor.com");
		emails.add("email2@servidor.com");
		
		return emails;
	}
}
