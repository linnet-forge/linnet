package LINNET.webcore;

import LINNET.webcore.configuration.ConfigSet;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.logging.Logger;

@SpringBootApplication
public class WebcoreApplication {
	private static final Logger logger = Logger.getLogger(WebcoreApplication.class.getName());

	public static void main(String[] args) throws IOException {
		ConfigSet configSet = new ConfigSet();
		WebcoreApplication app = new WebcoreApplication();
		configSet.setCfg();
		try {
			SpringApplication.run(WebcoreApplication.class, args);
		} catch (Exception e){
			logger.warning("Error with booting module " + e);
		}

	}

	@PreDestroy
	public void shutDown() throws IOException {
		ConfigSet configSet = new ConfigSet();
		configSet.clearCfg();
	}
}
