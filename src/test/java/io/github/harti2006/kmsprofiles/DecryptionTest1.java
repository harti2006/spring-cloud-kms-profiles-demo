package io.github.harti2006.kmsprofiles;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=aws1")
@Ignore
public class DecryptionTest1 {

    @Autowired
    private DemoProperties props;

    @Test
    public void runTest() {
        assertThat(props.getProfilePrecedence()).isEqualTo("Encrypted in Account 1");
    }
}
