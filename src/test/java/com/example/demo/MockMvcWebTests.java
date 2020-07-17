package com.example.demo;

import com.example.demo.domain.Book;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class MockMvcWebTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void homePage() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("readingList"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("readingList"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("books"))
                .andExpect(MockMvcResultMatchers.model().attribute("books",
                        Matchers.is(Matchers.empty())));
    }


    public void postBook () throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/readingList")
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .param("title", "book title")
        .param("author", "book author")
        .param("isbn", "1234567890")
        .param("description", "Description"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.header().string("Location", "/readingList"));

        Book expectedBook = new Book();
//        expectedBook.setId(1L);
        expectedBook.setReader("hctym");
        expectedBook.setTitle("book author");
        expectedBook.setIsbn("121212");
        expectedBook.setDescription("asas");


        mockMvc.perform(MockMvcRequestBuilders.get("/readingList"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("readingList"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("books"))
                .andExpect(MockMvcResultMatchers.model().attribute("books", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.model().attribute("books",
                        Matchers.contains(Matchers.samePropertyValuesAs(expectedBook))));

    }

}
