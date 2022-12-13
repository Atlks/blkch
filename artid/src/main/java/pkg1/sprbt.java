package pkg1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class sprbt {
	public static void main(String[] args) {
		SpringApplication.run(sprbt.class, args);
	}
}

@RestController
class HelloWorldController2 {
	@RequestMapping("/a")
	public String hello() {
		return "halo a reps";
	}
}