package es.rf.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Cambios para ver reositorio
@SpringBootApplication(scanBasePackages={"es.rf.tienda"})
public class S4TiendaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(S4TiendaSpringApplication.class, args);
		
		
	}
}
