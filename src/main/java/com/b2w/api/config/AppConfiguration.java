package com.b2w.api.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.WebApplicationInitializer;

/**
 *
 * @author rketner
 */
@PropertySource(value = {"classpath:application.properties"})
@SpringBootApplication(scanBasePackages = {"com.b2w.*"})
public class AppConfiguration extends SpringBootServletInitializer implements WebApplicationInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AppConfiguration.class);
    }

}
