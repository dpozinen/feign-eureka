package demo;

import demo.clients.HelloClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Spencer Gibb
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class HelloClientApplication {

	@Autowired
	HelloClient client;

	@Autowired
	RestTemplateBuilder builder;

	@RequestMapping("/")
	public String hello() {
		return client.hello();
	}

	@GetMapping("/play")
	HelloClient.PlayResponseValue playResponseValue() {
		return client.playValue();
	}


	public static void main(String[] args) {
		SpringApplication.run(HelloClientApplication.class, args);
	}
}
