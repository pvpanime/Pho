package dev.nemi.pho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PhoApplication {

  public static void main(String[] args) {
    SpringApplication.run(PhoApplication.class, args);
  }

}
