package cz.iddqd.imageleech.execution;

import jakarta.annotation.Nonnull;

public interface ScrapperTaskQueue
{
	@Nonnull
	ScrapTaskId enqueue(@Nonnull ScrapRequest scrapRequest);

	String getName();
}
