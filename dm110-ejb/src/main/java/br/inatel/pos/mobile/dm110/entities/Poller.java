package br.inatel.pos.mobile.dm110.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "equipment")
@SequenceGenerator(name = "seq_equipment", sequenceName = "seq_equipment", allocationSize = 1)
public class Poller {

	@Id
	@GeneratedValue(generator = "seq_equipment", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "ip")
	private String ip;

	@Column(name = "status")
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
