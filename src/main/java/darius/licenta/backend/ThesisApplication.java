package darius.licenta.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EntityScan("darius.licenta.backend.domain")
public class ThesisApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThesisApplication.class, args);
    }

}
