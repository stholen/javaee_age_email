package br.com.stholen.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.stholen.Dao.AgendamentoEmailDao;
import br.com.stholen.Entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailBusiness {
	
	@Inject
	private AgendamentoEmailDao agendamentoEmailDao;
	
	public List<AgendamentoEmail> listarAgendamentosEmail() {
		return agendamentoEmailDao.listarAgendamentoEmail();
	}
	
	public void salvarAgendamentoEmail(AgendamentoEmail agendamentoEmail) {
		agendamentoEmail.setEnviado(false);
		agendamentoEmailDao.salvarAgendamentoEmail(agendamentoEmail);
	}
}
