package com.example.demo;

import org.junit.Test;
import org.junit.internal.Classes;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.annotation.WebInitParam;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
public class SimpleWebTest {

    @Test(expected = HttpClientErrorException.class)
    public void pageNotFound(){
        try {
            String url = "https://www.baidu.com";
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(url, String.class);
            System.out.println(result);
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode());
            throw e;
        }

    }
}
