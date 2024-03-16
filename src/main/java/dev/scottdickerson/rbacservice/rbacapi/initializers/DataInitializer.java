package dev.scottdickerson.rbacservice.rbacapi.initializers;

import dev.scottdickerson.rbacservice.rbacapi.model.Credential;
import dev.scottdickerson.rbacservice.rbacapi.repositories.CredentialsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;


import java.net.URL;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
@Slf4j
public class DataInitializer {
    private final CredentialsRepository credentialsRepository;
    private final Faker faker = new Faker();

    @EventListener(ApplicationReadyEvent.class)
    public void setupCredentials() {
        log.info("Setting up credentials");
        credentialsRepository.deleteAll();
        List<String> intents = List.of("Play music", "Check weather", "Check heart rate", "Book flights");
        List<String> users = List.of("admin", "friend", "nobody");
    users.forEach(
        user ->
            intents.forEach(
                intent -> {
                  Credential newCredential =
                      Credential.builder()
                          .apiKey("apiKey")
                          .intentName(intent)
                          .apiKey(UUID.randomUUID().toString())
                          .userName(user)
                          .serviceURL(faker.internet().url())
                          .build();
                  log.info("Saving new Credential {}", newCredential.toString());
                  credentialsRepository.save(newCredential);
                }));
    }
}
