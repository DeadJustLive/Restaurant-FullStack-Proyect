package cl.triskeledu.sucursales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestaurantSucursalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantSucursalesApplication.class, args);
	}

}
