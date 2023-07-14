package cz.iddqd.imageleech.execution;

import jakarta.annotation.Nonnull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.concurrent.Callable;

public final class ScrapperTask implements Callable<ScrapperTaskResult>
{
	private static final Logger LOG = LoggerFactory.getLogger(ScrapperTask.class);

	@Nonnull private final ScrapTaskId scrapTaskId;
	@Nonnull private final ScrapRequest scrapRequest;

	public ScrapperTask(
			@Nonnull ScrapTaskId scrapTaskId,
			@Nonnull ScrapRequest scrapRequest
	)
	{
		this.scrapTaskId = Objects.requireNonNull(scrapTaskId);
		this.scrapRequest = Objects.requireNonNull(scrapRequest);
	}

	@Override
	public ScrapperTaskResult call() throws Exception
	{
		LOG.info("Executing scrapper task '{}': {}", scrapTaskId, scrapRequest);

		return new ScrapperTaskResult();
	}
}
