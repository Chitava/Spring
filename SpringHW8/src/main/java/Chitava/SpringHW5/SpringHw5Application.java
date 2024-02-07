package Chitava.SpringHW5;

import Chitava.SpringHW5.services.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;


@SpringBootApplication

public class SpringHw5Application {
	private static Logger logger = Logger.getLogger(SpringHw5Application.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(SpringHw5Application.class, args);
	}
	var c = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

	var service = c.getBean(NoteService.class);
}
