package cz.iddqd.imageleech.execution;

import jakarta.annotation.Nonnull;

import java.util.Objects;

public class ScrapperEnqueueException extends Exception
{
	private final ScrapTaskId scrapTaskId;

	public ScrapperEnqueueException(@Nonnull ScrapTaskId scrapTaskId, @Nonnull String message, @Nonnull Throwable cause)
	{
		super(Objects.requireNonNull(message), Objects.requireNonNull(cause));
		this.scrapTaskId = Objects.requireNonNull(scrapTaskId);
	}

	public ScrapTaskId getScrapTaskId()
	{
		return scrapTaskId;
	}
}
