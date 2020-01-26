package com.inquisitive.userservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URL;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootApplication(scanBasePackages = {"com.inquisitive.userservice.controller"})
class UserserviceApplicationTests {
    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;


    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/user/hello");
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        assertThat(response.getBody().equals("Hello World"));
    }
}
