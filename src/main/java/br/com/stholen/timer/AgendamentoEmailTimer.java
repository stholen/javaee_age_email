package br.com.stholen.timer;

import java.util.List;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import br.com.stholen.Entity.AgendamentoEmail;
import br.com.stholen.business.AgendamentoEmailBusiness;

//Anotado desta forma para que o JAvaee nao deixe mais de um processo rodando
//gerando concorrencia
@Singleton
public class AgendamentoEmailTimer {
	//este logger nao é o que criamos anteriormente, ele so esta aqui para um teste
	//private static Logger logger = Logger.getLogger(AgendamentoEmailTimer.class.getName());
	//job que roda de 10 em 10 minutos com objetivo de enviar nossos
	//emails pendentes
	
	@Inject
	private AgendamentoEmailBusiness agendamentoEmailBusiness;
	
	@Schedule(hour="*",minute="*")
	public void enviarEmailsAgendados( ) {
		List<AgendamentoEmail> agendamentoEmails = agendamentoEmailBusiness.listarAgendamentosEmailNaoEnviados();
		agendamentoEmails.stream().forEach(agendamentoEmail-> agendamentoEmailBusiness.enviarEmail(agendamentoEmail));
	}
}
