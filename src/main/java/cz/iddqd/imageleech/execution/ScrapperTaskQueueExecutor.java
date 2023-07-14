package cz.iddqd.imageleech.execution;

import jakarta.annotation.Nonnull;

public interface ScrapperTaskQueueExecutor
{
	@Nonnull
	ScrapTaskId enqueue(@Nonnull ScrapRequest scrapRequest) throws ScrapperEnqueueException;

	String getName();
}
