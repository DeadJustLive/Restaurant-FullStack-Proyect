package cl.triskeledu.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestaurantMenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantMenuApplication.class, args);
	}

}
