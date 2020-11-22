package ru.sergei.komarov.med;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Locale;

@SpringBootApplication
public class MedApplication {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        ApplicationContext applicationContext = SpringApplication.run(
                MedApplication.class,
                args
        );
        Environment environment = applicationContext.getEnvironment();

        System.out.println("\n\tWorking Directory = " + System.getProperty("user.dir"));

        String protocol = "http";
        if (environment.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }

        System.out.println("\tHost: " + protocol + "://localhost:" + environment.getProperty("server.port") + "\n");

    }
}
