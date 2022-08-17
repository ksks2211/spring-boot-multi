package kr.yoonyeong.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author rival
 * @since 2022-08-16
 */
@WebMvcTest(HelloController.class)
class HelloControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void hello_controller_test() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello"))
            .andExpect(status().isOk())
            .andExpect(content().string(hello));
    }

    @Test
    public void hello_dto_test() throws Exception {
        String name="kanye west";
        Long age = 50L;

        mvc.perform(get("/hello/dto").param("name",name).param("age",String.valueOf(age)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value(name))
            .andExpect(jsonPath("$.age").value(age));
    }
}