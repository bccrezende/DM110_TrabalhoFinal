package br.inatel.pos.mobile.dm110.to;

import java.io.Serializable;

public class PollerTo implements Serializable {

	private static final long serialVersionUID = 2693625650697491893L;

	private Integer id;
	private String ip;
	private String status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}
