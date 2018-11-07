package io.github.harti2006.kmsprofiles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=profile1")
public class Profile1Test {

    @Autowired
    private DemoProperties props;

    @Test
    public void runTest() {
        // "Default" profile is not used, because profile1 is already active
        assertThat(props.isApplicationYamlLoaded()).isTrue();
        assertThat(props.isApplicationDefaultYamlLoaded()).isFalse();
        assertThat(props.isApplicationProfile1YamlLoaded()).isTrue();
        assertThat(props.isApplicationProfile2YamlLoaded()).isFalse();

        assertThat(props.getProfilePrecedence()).isEqualTo("application-profile1.yaml");
    }
}
