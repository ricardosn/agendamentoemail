package br.com.alura.timer;

import java.util.List;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import br.com.alura.business.AgendamentoEmailBusiness;
import br.com.alura.entity.AgendamentoEmail;

@Singleton
public class AgendamentoEmailTimer {
	
	@Inject
	private AgendamentoEmailBusiness agendamentoEmailBusiness;
	
	@Schedule(hour="*",minute="*")
	public void enviarEmailsAgendados() {
		
		List<AgendamentoEmail> agendamentoEmails = agendamentoEmailBusiness.listarAgendamentosEmailNaoEnviados();
		agendamentoEmails
			.stream()
			.forEach(agendamentoEmail-> agendamentoEmailBusiness.enviarEmail(agendamentoEmail));
		
	}

}
