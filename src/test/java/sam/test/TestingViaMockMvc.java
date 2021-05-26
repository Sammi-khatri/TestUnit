package sam.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(RestApis.class)
public class TestingViaMockMvc {
    @Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("findAll")
    public void findAll() throws Exception{
        this.mockMvc.perform(get("/getAll")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("name")));
    }

    @Test
    @DisplayName("findById")
    public void findById() throws Exception{
        this.mockMvc.perform(get("/findById/{id}",1)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("name")));
    }

    @Test
    public void createEmployeeAPI() throws Exception
    {
        this.mockMvc.perform( MockMvcRequestBuilders
                .post("/createData")
                .content(asJsonString(new TestUnitPojo(0, "Aone", "Asing", "XYZ", "Job")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Cookie cookie = new Cookie("customData", "customString");
     *
     * mockMvc.perform(MockMvcRequestBuilders.post(MY_URL)
     *         .cookie(cookie)
     *         .accept(MediaType.APPLICATION_JSON_VALUE)
     *         .contentType(MediaType.APPLICATION_JSON_VALUE)
     *         .content(ConversionUtil.objectToString(BODY_OF_MY_REQUEST)))
     *         .andExpect(status().isCreated());
     */
}
