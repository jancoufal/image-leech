package cz.iddqd.imageleech;

import cz.iddqd.imageleech.execution.ScrapperTaskQueueImpl;
import cz.iddqd.imageleech.service.Pong;
import cz.iddqd.imageleech.service.Scrap;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeechResourceConfig extends ResourceConfig
{
	private static final Logger LOG = LoggerFactory.getLogger(LeechResourceConfig.class);

	public LeechResourceConfig()
	{
		LOG.info("Initializing {}.", LeechResourceConfig.class.getSimpleName());

		// singletons
		register(ScrapperTaskQueueImpl.class);

		// services
		register(Pong.class);
		register(Scrap.class);
	}
}
