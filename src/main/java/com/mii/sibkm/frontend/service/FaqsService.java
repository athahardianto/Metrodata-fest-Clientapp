/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.service;

import com.mii.sibkm.frontend.model.Faqs;
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
public class FaqsService {
    private RestTemplate restTemplate;
    
        @Autowired
    public FaqsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/faqs")
    private String url;
    
    public List<Faqs> getAll() {
        return restTemplate.exchange("http://localhost:8088/faqs", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Faqs>>() {
                }).getBody();
    }
    
    public List<Faqs> searchByKeyword(String question){
        return restTemplate.exchange("http://localhost:8088/faqs/search"+question, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Faqs>>() {
                }).getBody();
    }
     public Faqs create(Faqs faqs) {
        return restTemplate.exchange("http://localhost:8088/faqs", HttpMethod.POST, new HttpEntity(faqs),
                new ParameterizedTypeReference<Faqs>() {
                }).getBody();
    }
     
    public Faqs getById(Long id){
        return restTemplate.exchange("http://localhost:8088/faqs/"+id, HttpMethod.GET, null,
                new ParameterizedTypeReference<Faqs>(){
                }).getBody();
    }
    
    public Faqs update(Long id, Faqs faqs){
        return restTemplate.exchange("http://localhost:8088/faqs/"+id, HttpMethod.PUT, new HttpEntity(faqs),
                new ParameterizedTypeReference<Faqs>(){
                }).getBody();
    }
    public Faqs delete(Long id){
        return restTemplate.exchange("http://localhost:8088/faqs/"+id, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<Faqs>(){
                }).getBody();
    }
}
