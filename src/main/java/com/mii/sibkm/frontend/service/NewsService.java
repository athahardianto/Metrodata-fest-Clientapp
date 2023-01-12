/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.service;

import com.mii.sibkm.frontend.model.News;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author khali
 */

@AllArgsConstructor
@Service
public class NewsService {
    private RestTemplate restTemplate;
    
        @Autowired
    public NewsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/news")
    private String url;
    
    public List<News> getAll() {
        return restTemplate.exchange("http://localhost:8088/news", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<News>>() {
                }).getBody();
    }
    
     public News create(News news) {
        return restTemplate.exchange("http://localhost:8088/news", HttpMethod.POST, new HttpEntity(news),
                new ParameterizedTypeReference<News>() {
                }).getBody();
    }
     
    public News getById(Long id){
        return restTemplate.exchange("http://localhost:8088/news/"+id, HttpMethod.GET, null,
                new ParameterizedTypeReference<News>(){
                }).getBody();
    }
    
    public News update(Long id, News news){
        return restTemplate.exchange("http://localhost:8088/news/"+id, HttpMethod.PUT, new HttpEntity(news),
                new ParameterizedTypeReference<News>(){
                }).getBody();
    }
    public News delete(Long id){
        return restTemplate.exchange("http://localhost:8088/news/"+id, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<News>(){
                }).getBody();
    }       
}
