/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.service;

import com.mii.sibkm.frontend.model.Tickets;
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
public class TicketsService {
    private RestTemplate restTemplate;
    
        @Autowired
    public TicketsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/tickets")
    private String url;
    
    public List<Tickets> getAll() {
        return restTemplate.exchange("http://localhost:8088/tickets", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Tickets>>() {
                }).getBody();
    }
    
     public Tickets create(Tickets tickets) {
        return restTemplate.exchange("http://localhost:8088/tickets", HttpMethod.POST, new HttpEntity(tickets),
                new ParameterizedTypeReference<Tickets>() {
                }).getBody();
    }
     
    public Tickets getById(Long id){
        return restTemplate.exchange("http://localhost:8088/tickets/"+id, HttpMethod.GET, null,
                new ParameterizedTypeReference<Tickets>(){
                }).getBody();
    }
    
    public Tickets update(Long id, Tickets tickets){
        return restTemplate.exchange("http://localhost:8088/tickets/"+id, HttpMethod.PUT, new HttpEntity(tickets),
                new ParameterizedTypeReference<Tickets>(){
                }).getBody();
    }
    public Tickets delete(Long id){
        return restTemplate.exchange("http://localhost:8088/tickets/"+id, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<Tickets>(){
                }).getBody();
    }   
}
