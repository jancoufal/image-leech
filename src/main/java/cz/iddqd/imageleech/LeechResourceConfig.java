package cz.iddqd.imageleech;

import cz.iddqd.imageleech.service.Pong;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public final class LeechResourceConfig extends ResourceConfig
{
	private static final Logger LOG = LoggerFactory.getLogger(LeechResourceConfig.class);

	public LeechResourceConfig()
	{
		LOG.info("Initializing {}.", LeechResourceConfig.class.getSimpleName());

		// services
		register(Pong.class);
	}
}
