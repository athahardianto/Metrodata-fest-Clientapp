/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.service;

import com.mii.sibkm.frontend.model.User;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserService {
    private RestTemplate restTemplate;
    
        @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/user")
    private String url;
    
    public List<User> getAll() {
        return restTemplate.exchange("http://localhost:8088/user", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<User>>() {
                }).getBody();
    }
    
     public User create(User user) {
        return restTemplate.exchange("http://localhost:8088/user", HttpMethod.POST, new HttpEntity(user),
                new ParameterizedTypeReference<User>() {
                }).getBody();
    }
     
    public User getById(Long id){
        return restTemplate.exchange("http://localhost:8088/user/"+id, HttpMethod.GET, null,
                new ParameterizedTypeReference<User>(){
                }).getBody();
    }

    public User getByUsername(String username){
        return restTemplate.exchange("http://localhost:8088/user/username?username="+username, HttpMethod.GET, null,
                new ParameterizedTypeReference<User>(){
                }).getBody();
    }
    
    public User update(Long id, User user){
        return restTemplate.exchange("http://localhost:8088/user/"+id, HttpMethod.PUT, new HttpEntity(user),
                new ParameterizedTypeReference<User>(){
                }).getBody();
    }
    public User delete(Long id){
        return restTemplate.exchange("http://localhost:8088/user/"+id, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<User>(){
                }).getBody();
    }

}
