package cz.iddqd.imageleech.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Service;

@Service
@Produces(MediaType.APPLICATION_JSON)
@Path("v1")
public class Pong
{
	@GET @Path("pong")
	public Response getPong()
	{
		return Response.status(Response.Status.OK).build();
	}
}
