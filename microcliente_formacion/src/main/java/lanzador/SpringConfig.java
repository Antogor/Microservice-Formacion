package lanzador;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages= {"service"})
@EnableWebMvc
@Configuration
public class SpringConfig{
	
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	
}
