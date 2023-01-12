/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.service;

import com.mii.sibkm.frontend.model.Lineup;
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
public class LineupService {
    private RestTemplate restTemplate;
    
        @Autowired
    public LineupService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/lineup")
    private String url;
    
    public List<Lineup> getAll() {
        return restTemplate.exchange("http://localhost:8088/lineup", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Lineup>>() {
                }).getBody();
    }
    
     public Lineup create(Lineup lineup) {
        return restTemplate.exchange("http://localhost:8088/lineup", HttpMethod.POST, new HttpEntity(lineup),
                new ParameterizedTypeReference<Lineup>() {
                }).getBody();
    }
     
    public Lineup getById(Long id){
        return restTemplate.exchange("http://localhost:8088/lineup/"+id, HttpMethod.GET, null,
                new ParameterizedTypeReference<Lineup>(){
                }).getBody();
    }
    
    public Lineup update(Long id, Lineup lineup){
        return restTemplate.exchange("http://localhost:8088/lineup/"+id, HttpMethod.PUT, new HttpEntity(lineup),
                new ParameterizedTypeReference<Lineup>(){
                }).getBody();
    }
    public Lineup delete(Long id){
        return restTemplate.exchange("http://localhost:8088/lineup/"+id, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<Lineup>(){
                }).getBody();
    }  
}
