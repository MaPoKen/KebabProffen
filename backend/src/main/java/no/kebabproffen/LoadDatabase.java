package no.kebabproffen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import no.kebabproffen.models.User;
import no.kebabproffen.repositories.UserRepository;

@Configuration
public class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(UserRepository repository) {
    return args -> {
      log.info("Preloading " + repository.save(new User("Lars Sørlie", "burglar","b@b.b")));
      log.info("Preloading " + repository.save(new User("Casper Vestengen", "thief","a@a.a")));
    };
  }
}