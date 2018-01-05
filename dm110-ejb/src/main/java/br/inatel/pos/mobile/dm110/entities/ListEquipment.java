package br.inatel.pos.mobile.dm110.entities;

import java.io.Serializable;
import java.util.List;

public class ListEquipment implements Serializable{

	private static final long serialVersionUID = -2638569144436589437L;
	
	
	public List<String> ip;

	public List<String> getIp() {
		return ip;
	}

	public void setIp(List<String> ip) {
		this.ip = ip;
	}
}
