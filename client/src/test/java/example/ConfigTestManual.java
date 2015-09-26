package example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * This test can be used to ensure that the client is pulling down
 * the configuration property from the server. It requires that the
 * server be running, so it's not included as part of the normal
 * test suite.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ConfigTestManual {

    @Value("${info.foo}")
    private String fooProperty;


    @Test
    public void shouldLoadConfig() {
        assertThat(fooProperty, is("bar"));
    }
}
