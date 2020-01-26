package com.inquisitive.userservice.controller;


import org.hamcrest.Matchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inquisitive.userservice.model.Account;
import com.inquisitive.userservice.model.AccountStatus;
import com.inquisitive.userservice.model.Role;
import com.inquisitive.userservice.repository.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by ankitmishra on 26/01/20.
 */
@RunWith(SpringRunner.class)
public class UserControllerTest{
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserRepository userRepository;
    private JacksonTester<Account> account;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void canRetrieveByIdWhenExists() throws Exception {
        // given
        given(userRepository.getOne(1L))
                .willReturn(getMockUserWithId(1L));

        // when
        MockHttpServletResponse response = mvc.perform(
                get("/user/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                account.write(getMockUserWithId(1l)).getJson()
        );
    }


    private Account getMockUserWithId(Long id) {
        Account ac = new Account();
        ac.setPhone(123456789);
        ac.setPassword("test123");
        ac.setName("Ankit");
        ac.setEmail("test@test.com");
        ac.setRole(Role.Admin);
        ac.setStatus(AccountStatus.ACTIVE);
        return ac;
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

}