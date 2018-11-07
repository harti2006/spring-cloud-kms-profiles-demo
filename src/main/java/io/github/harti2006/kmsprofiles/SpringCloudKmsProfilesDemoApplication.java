package io.github.harti2006.kmsprofiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DemoProperties.class)
public class SpringCloudKmsProfilesDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudKmsProfilesDemoApplication.class, args);
    }
}
