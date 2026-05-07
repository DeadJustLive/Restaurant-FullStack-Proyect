package cl.triskeledu.notificaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestaurantNotificacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantNotificacionesApplication.class, args);
	}

}
