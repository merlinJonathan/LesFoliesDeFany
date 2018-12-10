package fr.kurzen.lesFoliesDeFany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "fr.kurzen")
@EnableJpaRepositories(basePackages = "fr.kurzen")
@EnableJpaAuditing
public class App 
{
    public static void main( String[] args )
    {
		SpringApplication.run(App.class, args);
		System.out.println("Serveur lance!");
    }
}
