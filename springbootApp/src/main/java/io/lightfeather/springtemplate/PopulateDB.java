package io.lightfeather.springtemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class PopulateDB {

    private static final Logger log = LoggerFactory.getLogger(PopulateDB.class);

    /*
    @Bean
    CommandLineRunner initDatabase(EmployeeRepo repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Employee("Boris", "Ruiz", "borisruiz4@gmail.com", "7874075043","John Smith")));
        };
    }

    */
}