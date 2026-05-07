package cl.triskeledu.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestaurantInventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantInventarioApplication.class, args);
	}

}
