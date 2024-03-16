package dev.scottdickerson.rbacservice.rbacapi.api;

import dev.scottdickerson.rbacservice.rbacapi.model.Credential;
import dev.scottdickerson.rbacservice.rbacapi.repositories.CredentialsRepository;

import java.util.List;

import dev.scottdickerson.rbacservice.rbacapi.services.ActionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class APIController {
  private final CredentialsRepository credentialsRepository;
  private final ActionService actionService;


  @GetMapping("/credentials")
    public ResponseEntity<List<Credential>> getCredentials() {
        return ResponseEntity.ok(credentialsRepository.findAll());
    }

  @PostMapping("/action/{intentName}/user/{username}")
  public ResponseEntity<String> performIntent(@PathVariable String intentName, @PathVariable String username) {
    return actionService.performAction(intentName, username);
  }


}
