package com.example.publishingservice;

import com.example.publishingservice.models.ArticleDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ArticleControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void testCreateArticle() throws Exception {
        ArticleDTO articleDTO = new ArticleDTO("Test", "Hello", "Name", "23-10", "Body", "Theme", "Theme1");
        String articleJson = new ObjectMapper().writeValueAsString(articleDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("api/article")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(articleJson)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetArticle() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/articles/{articleId}", "test-21-10")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetArticleNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/articles/{articleId}", "")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
