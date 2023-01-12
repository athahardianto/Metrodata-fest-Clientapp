package com.mii.sibkm.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mii.sibkm.frontend.model.Profile;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProfileService {
    private RestTemplate restTemplate;
    
        @Autowired
    public ProfileService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/user")
    private String url;
    
    public List<Profile> getAll() {
        return restTemplate.exchange("http://localhost:8088/profile", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Profile>>() {
                }).getBody();
    }
    
     public Profile create(Profile profile) {
        return restTemplate.exchange("http://localhost:8088/profile", HttpMethod.POST, new HttpEntity(profile),
                new ParameterizedTypeReference<Profile>() {
                }).getBody();
    }
     
    public Profile getById(Long id){
        return restTemplate.exchange("http://localhost:8088/profile/"+id, HttpMethod.GET, null,
                new ParameterizedTypeReference<Profile>(){
                }).getBody();
    }

    public Profile getByUsername(String username){
        return restTemplate.exchange("http://localhost:8088/profile/username?username="+username, HttpMethod.GET, null,
                new ParameterizedTypeReference<Profile>(){
                }).getBody();
    }
    
    public Profile update(Long id, Profile profile){
        return restTemplate.exchange("http://localhost:8088/profile/"+id, HttpMethod.PUT, new HttpEntity(profile),
                new ParameterizedTypeReference<Profile>(){
                }).getBody();
    }
    public Profile delete(Long id){
        return restTemplate.exchange("http://localhost:8088/profile/"+id, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<Profile>(){
                }).getBody();
    }
}
