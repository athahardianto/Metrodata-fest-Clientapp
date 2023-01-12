/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.service;

import com.mii.sibkm.frontend.model.Orders;
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
public class OrdersService {
    private RestTemplate restTemplate;
    
        @Autowired
    public OrdersService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/orders")
    private String url;
    
    public List<Orders> getAll() {
        return restTemplate.exchange("http://localhost:8088/orders", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Orders>>() {
                }).getBody();
    }
    
     public Orders create(Orders orders) {
        return restTemplate.exchange("http://localhost:8088/orders", HttpMethod.POST, new HttpEntity(orders),
                new ParameterizedTypeReference<Orders>() {
                }).getBody();
    }
     
    public Orders getById(Long id){
        return restTemplate.exchange("http://localhost:8088/orders/"+id, HttpMethod.GET, null,
                new ParameterizedTypeReference<Orders>(){
                }).getBody();
    }
    
    public Orders update(Long id, Orders orders){
        return restTemplate.exchange("http://localhost:8088/orders/"+id, HttpMethod.PUT, new HttpEntity(orders),
                new ParameterizedTypeReference<Orders>(){
                }).getBody();
    }
    public Orders delete(Long id){
        return restTemplate.exchange("http://localhost:8088/orders/"+id, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<Orders>(){
                }).getBody();
    }    
}
