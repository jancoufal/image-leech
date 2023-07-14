package cz.iddqd.imageleech.execution;

import jakarta.annotation.Nonnull;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Singleton
@Component
public class ScrapperTaskQueueImpl implements ScrapperTaskQueue
{
	private static final Logger LOG = LoggerFactory.getLogger(ScrapperTaskQueueImpl.class);
	public ScrapperTaskQueueImpl()
	{
		LOG.info("Initializing {}.", ScrapperTaskQueueImpl.class.getSimpleName());
	}

	@Nonnull
	@Override
	public ScrapTaskId enqueue(@Nonnull ScrapRequest scrapRequest)
	{
		return new ScrapTaskId("test-guid");
	}

	@Override
	public String getName()
	{
		return ScrapperTaskQueueImpl.class.getSimpleName();
	}
}
