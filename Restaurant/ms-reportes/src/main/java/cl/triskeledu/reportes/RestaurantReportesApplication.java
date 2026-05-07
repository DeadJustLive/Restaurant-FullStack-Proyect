package cl.triskeledu.reportes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestaurantReportesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantReportesApplication.class, args);
	}

}
