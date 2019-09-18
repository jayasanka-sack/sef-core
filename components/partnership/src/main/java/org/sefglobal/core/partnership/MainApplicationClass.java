package org.sefglobal.core.partnership;

import org.sefglobal.core.partnership.configuration.ConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
public class MainApplicationClass extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MainApplicationClass.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(MainApplicationClass.class, args);
    }

}
