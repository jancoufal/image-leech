package cz.iddqd.imageleech.execution;

import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Singleton
@Component
public class RequestQueueImpl implements RequestQueue
{
	private static final Logger LOG = LoggerFactory.getLogger(RequestQueueImpl.class);
	public RequestQueueImpl()
	{
		LOG.info("Initializing {}.", RequestQueueImpl.class.getSimpleName());
	}

	@Override
	public String getName()
	{
		return RequestQueueImpl.class.getSimpleName();
	}
}
