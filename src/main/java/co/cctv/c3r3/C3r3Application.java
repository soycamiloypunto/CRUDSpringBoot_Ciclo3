package co.cctv.c3r3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@EntityScan(basePackages = {"co.cctv.c3r3.entity"})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class C3r3Application {

	public static void main(String[] args) {
		SpringApplication.run(C3r3Application.class, args);
	}

}
