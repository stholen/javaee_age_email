package br.com.stholen.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.stholen.Dao.AgendamentoEmailDao;

@Stateless
public class AgendamentoEmailBusiness {
	
	@Inject
	private AgendamentoEmailDao agendamentoEmailDao;
	
	public List<String> listarAgendamentosEmail() {
		return agendamentoEmailDao.listarAgendamentoEmail();
	}
}
