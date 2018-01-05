package br.inatel.pos.mobile.dm110.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/poller")
public interface PollerService {

	@GET
	@Path("/start/{ip}/{mask}")
	@Produces(MediaType.APPLICATION_JSON)
	void calcNetwork(@PathParam("ip") String ip, @PathParam("mask") int mask);
	
	@GET
	@Path("/status/{ip}")
	@Produces(MediaType.APPLICATION_JSON)
	String searchStatus(@PathParam("ip") String ip);
}
