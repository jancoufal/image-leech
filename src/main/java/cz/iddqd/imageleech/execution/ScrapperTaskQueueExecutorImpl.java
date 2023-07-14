package cz.iddqd.imageleech.execution;

import jakarta.annotation.Nonnull;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Singleton
@Component
public class ScrapperTaskQueueExecutorImpl implements ScrapperTaskQueueExecutor
{
	private static final Logger LOG = LoggerFactory.getLogger(ScrapperTaskQueueExecutorImpl.class);

	private final ExecutorService executorService = Executors.newSingleThreadExecutor();

	public ScrapperTaskQueueExecutorImpl()
	{
		LOG.info("Initializing {}.", ScrapperTaskQueueExecutorImpl.class.getSimpleName());
	}

	@Nonnull
	@Override
	public ScrapTaskId enqueue(@Nonnull ScrapRequest scrapRequest) throws ScrapperEnqueueException
	{
		ScrapTaskId scrapTaskId = ScrapTaskId.create();

		try
		{
			ScrapperTask scrapperTask = new ScrapperTask(scrapTaskId, scrapRequest);
			executorService.submit(scrapperTask);
		}
		catch (Exception e)
		{
			throw new ScrapperEnqueueException(scrapTaskId, "Failed to enqueue new scrap request due to " + e.getClass().getSimpleName() + ": " + e.getMessage(), e);
		}

		return scrapTaskId;
	}

	@Override
	public String getName()
	{
		return ScrapperTaskQueueExecutorImpl.class.getSimpleName();
	}
}
