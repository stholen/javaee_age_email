package br.com.stholen.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.stholen.Entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<AgendamentoEmail> listarAgendamentoEmail(){
		
		String jpql = "Select a from AgendamentoEmail a";
		TypedQuery<AgendamentoEmail> query =  em.createQuery(jpql,AgendamentoEmail.class);
		return query.getResultList();
	}
	
	public void salvarAgendamentoEmail(AgendamentoEmail agendamentoEmail) {
		em.persist(agendamentoEmail);
	}
	
	public List<AgendamentoEmail> listarAgendamentosEmailPorEmail(String email){
		TypedQuery<AgendamentoEmail> query = em.createQuery("select a from AgendamentoEmail a where a.email=:email and a.enviado = false",AgendamentoEmail.class); 
		query.setParameter("email",email);
		
		return query.getResultList();
	}
}
