package cl.triskeledu.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestaurantAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantAuthApplication.class, args);
	}

}
