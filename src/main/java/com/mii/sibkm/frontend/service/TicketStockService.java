/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.service;

import com.mii.sibkm.frontend.model.TicketStock;
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
public class TicketStockService {
        private RestTemplate restTemplate;
    
        @Autowired
    public TicketStockService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/ticketstock")
    private String url;
    
    public List<TicketStock> getAll() {
        return restTemplate.exchange("http://localhost:8088/ticketstock", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<TicketStock>>() {
                }).getBody();
    }
    
     public TicketStock create(TicketStock ticketStock) {
        return restTemplate.exchange("http://localhost:8088/ticketstock", HttpMethod.POST, new HttpEntity(ticketStock),
                new ParameterizedTypeReference<TicketStock>() {
                }).getBody();
    }
     
    public TicketStock getById(Long id){
        return restTemplate.exchange("http://localhost:8088/ticketstock/"+id, HttpMethod.GET, null,
                new ParameterizedTypeReference<TicketStock>(){
                }).getBody();
    }
    
    public TicketStock update(Long id, TicketStock ticketStock){
        return restTemplate.exchange("http://localhost:8088/ticketstock/"+id, HttpMethod.PUT, new HttpEntity(ticketStock),
                new ParameterizedTypeReference<TicketStock>(){
                }).getBody();
    }
    public TicketStock delete(Long id){
        return restTemplate.exchange("http://localhost:8088/ticketstock/"+id, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<TicketStock>(){
                }).getBody();
    }   
}
