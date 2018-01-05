package br.inatel.pos.mobile.dm110.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.pos.mobile.dm110.entities.Poller;

@Stateless
public class PollerDAO {

	@PersistenceContext(unitName = "equipment")
	private EntityManager em;

	public String getStatus(String ip)
	{
	String status = "{ \"status\": \"Poller não encontrado\"}";
	List<Poller> pollerList = 
			 em.createQuery("from equipment e where e.ip=:ip", Poller.class)
			.setParameter("ip", ip)
			.getResultList();
			
	if(pollerList.size()>0){
			status = "{ \"status\":\""+pollerList.get(0).getStatus().trim()+"\"}";
	}
	return status;
		
	}
	
	public void insert(Poller poller) {
		em.persist(poller);
	}

}


