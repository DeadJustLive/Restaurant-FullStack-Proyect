package cl.triskeledu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(exclude = {ValidationAutoConfiguration.class})
@EnableEurekaServer
public class RestaurantEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantEurekaApplication.class, args);
	}

}
