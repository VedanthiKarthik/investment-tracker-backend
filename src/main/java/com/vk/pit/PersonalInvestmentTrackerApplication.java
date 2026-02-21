package com.vk.pit;

import com.vk.pit.configuration.external.KiteConfigs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = KiteConfigs.class)
//@EnableAspectJAutoProxy
public class PersonalInvestmentTrackerApplication {
	public static void main(String[] args) {
		SpringApplication.run(PersonalInvestmentTrackerApplication.class, args);
	}

}
