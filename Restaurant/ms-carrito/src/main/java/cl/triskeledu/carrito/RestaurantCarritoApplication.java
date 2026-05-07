package cl.triskeledu.carrito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestaurantCarritoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantCarritoApplication.class, args);
	}

}
