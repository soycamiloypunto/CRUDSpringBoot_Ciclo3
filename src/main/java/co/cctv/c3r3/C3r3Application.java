package co.cctv.c3r3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@EntityScan(basePackages = {"co.cctv.c3r3.entity"})
@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class})
public class C3r3Application {

	public static void main(String[] args) {
		SpringApplication.run(C3r3Application.class, args);
                
	}
        
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
                }
            };
        }
        
}
