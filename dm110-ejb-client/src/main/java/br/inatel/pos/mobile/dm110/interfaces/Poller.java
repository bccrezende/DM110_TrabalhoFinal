package br.inatel.pos.mobile.dm110.interfaces;

public interface Poller {

	void calcNetwork(String ip, int mask);
	
	String searchStatus(String ip);
}
