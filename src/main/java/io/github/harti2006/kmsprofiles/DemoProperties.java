package io.github.harti2006.kmsprofiles;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {

    private boolean applicationYamlLoaded;
    private boolean applicationDefaultYamlLoaded;
    private boolean applicationProfile1YamlLoaded;
    private boolean applicationProfile2YamlLoaded;

    private String profilePrecedence = "DemoProperties.class";
}
