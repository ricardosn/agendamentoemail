package br.com.alura.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.dao.AgendamentoEmailDao;
import br.com.alura.entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailBusiness {
	
	@Inject
	private AgendamentoEmailDao dao;

    public List<AgendamentoEmail> listarAgendamentosEmail() {
    	return dao.listarAgendamentoEmail();
    }
    
    public void salvarAgendamentoEmail(@Valid AgendamentoEmail agendamentoEmail) {
    	agendamentoEmail.setEnviado(false);
    	dao.salvarAgendamentoEmail(agendamentoEmail);
    }

}
