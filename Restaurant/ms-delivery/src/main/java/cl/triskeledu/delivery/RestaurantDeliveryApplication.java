package cl.triskeledu.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestaurantDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantDeliveryApplication.class, args);
	}

}
