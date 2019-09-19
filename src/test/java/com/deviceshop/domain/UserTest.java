package com.deviceshop.domain;

import com.deviceshop.model.Role;
import com.deviceshop.model.User;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

public class UserTest {


    @Test
    public void createUser() {
        User user = new User();
        user.setUsername("1");
        user.setPassword("1");
    }

    @Test
    public void testLocaleDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
    }

    @Test
    public void restRequest() {
        RestTemplate restTemplate = new RestTemplate();
        User user = User.builder()
                .username("SuttyRead6")
                .email("suttyread6@gmail.com")
                .firstName("Sutty")
                .lastName("Read")
                .birthday(LocalDate.of(1981, 1, 1))
                .role(Role.USER)
                .password("Password1!")
                .build();
        restTemplate.postForLocation("http://localhost:9000/users", user);
    }

}
