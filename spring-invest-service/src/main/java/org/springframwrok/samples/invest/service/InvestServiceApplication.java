
package org.springframwrok.samples.invest.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframwrok.samples.invest.service.system.VetsProperties;

@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties(VetsProperties.class)
public class InvestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestServiceApplication.class, args);
	}
}
