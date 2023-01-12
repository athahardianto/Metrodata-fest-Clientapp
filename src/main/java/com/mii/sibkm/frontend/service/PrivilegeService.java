package com.mii.sibkm.frontend.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mii.sibkm.frontend.model.Privilege;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PrivilegeService {

    private RestTemplate restTemplate;

    public List<Privilege> getAll() {
        return restTemplate.exchange("http://localhost:8088/privilege", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Privilege>>() {
                }).getBody();
    }
     public Privilege create(Privilege privilege) {
        return restTemplate.exchange("http://localhost:8088/privilege", HttpMethod.POST, new HttpEntity(privilege),
                new ParameterizedTypeReference<Privilege>() {
                }).getBody();
    }
    public Privilege getById(Long id){
        return restTemplate.exchange("http://localhost:8088/privilege/"+id, HttpMethod.GET, null,
                new ParameterizedTypeReference<Privilege>(){
                }).getBody();
    }
    public Privilege update(Long id, Privilege privilege){
        return restTemplate.exchange("http://localhost:8088/privilege/"+id, HttpMethod.PUT, new HttpEntity(privilege),
                new ParameterizedTypeReference<Privilege>(){
                }).getBody();
    }
    public Privilege delete(Long id){
        return restTemplate.exchange("http://localhost:8088/privilege/"+id, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<Privilege>(){
                }).getBody();
    }       
}
