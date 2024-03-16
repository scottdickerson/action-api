package dev.scottdickerson.rbacservice.rbacapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ActionApiApplication {

  public static void main(String[] args) {

    log.info("Starting Action API");
    SpringApplication.run(ActionApiApplication.class, args);
  }
}
