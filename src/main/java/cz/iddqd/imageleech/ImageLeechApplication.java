package cz.iddqd.imageleech;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ImageLeechApplication {

	private static final Logger LOG = LoggerFactory.getLogger(ImageLeechApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ImageLeechApplication.class, args);
	}

	@PostConstruct
	public void postConstruct()
	{
		LOG.info("{} constructed.", ImageLeechApplication.class.getSimpleName());
	}
}
