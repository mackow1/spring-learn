package pl.kowalczyk.maciej.spring.learn.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApartmentControllerHttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void createView() {
        // given

        // when
        String forObject = restTemplate.getForObject("http://localhost:" + port + "/apartments", String.class);

        // then
        Assertions.assertTrue(forObject.contains("List of apartments"));
    }
}