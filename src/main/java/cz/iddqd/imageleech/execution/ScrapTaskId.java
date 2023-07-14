package cz.iddqd.imageleech.execution;

import java.util.UUID;

public record ScrapTaskId(
		String uuid
)
{
	static ScrapTaskId create() {
		return new ScrapTaskId(UUID.randomUUID().toString());
	}
}
