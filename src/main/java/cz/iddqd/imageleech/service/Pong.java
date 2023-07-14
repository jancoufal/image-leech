package cz.iddqd.imageleech.service;

import cz.iddqd.imageleech.execution.ScrapperTaskQueueExecutor;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Produces(MediaType.APPLICATION_JSON)
@Path("v1")
public class Pong
{
	private static final Logger LOG = LoggerFactory.getLogger(Pong.class);

	private final ScrapperTaskQueueExecutor scrapperTaskQueueExecutor;

	@Inject
	public Pong(ScrapperTaskQueueExecutor scrapperTaskQueueExecutor)
	{
		LOG.debug("Initializing {}", Pong.class.getSimpleName());

		this.scrapperTaskQueueExecutor = Objects.requireNonNull(scrapperTaskQueueExecutor);
	}

	@GET @Path("pong")
	public Response getPong()
	{
		return Response.status(Response.Status.OK).entity(scrapperTaskQueueExecutor).build();
	}

	@GET @Path("error")
	public Response getError()
	{
		throw new WebApplicationException(
				"{ \"error\": \"expected\" }",
				418 // I'm a teapot (https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/418)
		);
	}
}
