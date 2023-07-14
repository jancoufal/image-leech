package cz.iddqd.imageleech.service;

import cz.iddqd.imageleech.execution.ScrapRequest;
import cz.iddqd.imageleech.execution.ScrapSource;
import cz.iddqd.imageleech.execution.ScrapTaskId;
import cz.iddqd.imageleech.execution.ScrapperTaskQueue;
import jakarta.annotation.Nonnull;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Produces(MediaType.APPLICATION_JSON)
@Path("")
public class Scrap
{
	private static final Logger LOG = LoggerFactory.getLogger(Scrap.class);

	private final ScrapperTaskQueue scrapperTaskQueue;

	@Inject
	public Scrap(ScrapperTaskQueue scrapperTaskQueue)
	{
		LOG.debug("Initializing {}", Scrap.class.getSimpleName());

		this.scrapperTaskQueue = Objects.requireNonNull(scrapperTaskQueue);
	}

	@GET @Path("scrap/{source}")
	public Response enqueueScrapTask(@Nonnull @PathParam("source") String scrapSource)
	{
		LOG.debug("enqueueScrapTask(scrapSource => {})", scrapSource);

		ScrapRequest scrapRequest = new ScrapRequest(ScrapSource.NOOP);
//		ScrapRequest scrapRequest = new ScrapRequest();

		ScrapTaskId scrapTaskId = scrapperTaskQueue.enqueue(scrapRequest);

		return Response.status(Response.Status.CREATED).entity(scrapTaskId).build();
	}
}
