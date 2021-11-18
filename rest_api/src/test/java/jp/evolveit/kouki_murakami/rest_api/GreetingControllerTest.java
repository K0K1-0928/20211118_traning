package jp.evolveit.kouki_murakami.rest_api;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import jp.evolveit.kouki_murakami.rest_api.api.GreetingController;

@WebMvcTest(controllers = GreetingController.class)
class GreetingControllerTest {
    
    private final MockMvc mockMvc;

    @Autowired
    public GreetingControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void testGreeting_success() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(Map.of("name", "test"));
        
        mockMvc.perform(MockMvcRequestBuilders
            .post("/api/greeting")
            .with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(json)
        )
            .andExpect(status().isOk())
            .andExpect(content().json("{'message':'Hello test!'}"));
    }
}
