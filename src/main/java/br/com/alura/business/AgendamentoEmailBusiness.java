package br.com.alura.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.dao.AgendamentoEmailDao;
import br.com.alura.entity.AgendamentoEmail;
import br.com.alura.exception.BusinessException;
import br.com.alura.interception.Logger;

@Stateless
@Logger
public class AgendamentoEmailBusiness {
	
	@Inject
	private AgendamentoEmailDao agendamentoEmailDao;
	
	public List<AgendamentoEmail> listarAgemndamentosEmail(){
	
		return agendamentoEmailDao.listarAgendamentosEmail();
		
	}
	
	public void salvarAgendamentoEmail( @Valid AgendamentoEmail agendamentoEmail) throws BusinessException {
		
		if(!agendamentoEmailDao
				.listarAgendamentosEmailPorEmail(agendamentoEmail.getEmail())
				.isEmpty()) {
			throw new BusinessException("Email já está agendado.");
			
		}
		
		agendamentoEmail.setEnviado(false);
		agendamentoEmailDao.salvarAgendamentoEmail(agendamentoEmail);
		
	}

}
