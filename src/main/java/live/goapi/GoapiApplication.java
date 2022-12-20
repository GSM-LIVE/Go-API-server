package live.goapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@ConfigurationProperties
@EnableConfigurationProperties
@ConfigurationPropertiesScan
@EnableJpaRepositories
public class GoapiApplication {

	public static void main(String[] args) {

		// teacher 버전 통합
		SpringApplication.run(GoapiApplication.class, args);
	}

}
