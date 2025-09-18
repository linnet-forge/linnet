package LINNET.webcore;

import LINNET.configuration.ConfigSet;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.Entity;
import jakarta.persistence.PreRemove;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@SpringBootApplication
public class WebcoreApplication {

	public static void main(String[] args) throws IOException {
		ConfigSet configSet = new ConfigSet();
		WebcoreApplication app = new WebcoreApplication();
		configSet.setCfg();
		try {
			SpringApplication.run(WebcoreApplication.class, args);
		} catch (Exception e){

		}

	}

	@PreDestroy
	public void shutDown() throws IOException {
		ConfigSet configSet = new ConfigSet();
		configSet.clearCfg();
	}
}
