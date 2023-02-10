package es.rf.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * La Aplicación web Tienda Incienso. Proyecto TalentCampus Accenture
 * 
 * @author e.a.martin.muriel
 *
 */
@SpringBootApplication(scanBasePackages={"es.rf.tienda"})
public class S4TiendaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(S4TiendaSpringApplication.class, args);
		
		
	}
}
