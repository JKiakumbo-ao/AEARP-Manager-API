package ao.sting.aearp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ao.sting.aearp.service.StudentService;
import ao.sting.aearp.storage.PhotoStorage;
import ao.sting.aearp.storage.local.PhotoStorageLocal;



@Configuration
@ComponentScan(basePackageClasses = StudentService.class)
public class ServiceConfig {

	@Bean
	public PhotoStorage fotoStorage() {
		return new PhotoStorageLocal();
	}
	
}
