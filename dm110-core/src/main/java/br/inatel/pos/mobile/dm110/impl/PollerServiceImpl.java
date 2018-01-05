package br.inatel.pos.mobile.dm110.impl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.pos.mobile.dm110.api.PollerService;
import br.inatel.pos.mobile.dm110.interfaces.PollerRemote;


@RequestScoped
public class PollerServiceImpl implements PollerService {

	@EJB(lookup = "java:app/dm110-ejb-1.0.0-SNAPSHOT/PollerBean!br.inatel.pos.mobile.dm110.interfaces.PollerRemote")
	private PollerRemote pollerBean;

	@Override
	public void calcNetwork(String ip, int mask) {
		pollerBean.calcNetwork(ip, mask);		
	}

	@Override
	public String searchStatus(String ip) {
		return pollerBean.searchStatus(ip);
	}

	

}
