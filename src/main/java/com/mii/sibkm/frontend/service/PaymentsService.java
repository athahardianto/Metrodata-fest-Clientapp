/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.service;

import com.mii.sibkm.frontend.model.Payments;
import com.mii.sibkm.frontend.model.dto.PaymentsRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author khali
 */
@AllArgsConstructor
@Service
public class PaymentsService {
        private RestTemplate restTemplate;
    
        @Autowired
    public PaymentsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/payments")
    private String url;
    
    public List<Payments> getAll() {
        return restTemplate.exchange("http://localhost:8088/payments", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Payments>>() {
                }).getBody();
    }
    
     public Payments create(PaymentsRequest paymentsRequest) {
        return restTemplate.exchange("http://localhost:8088/payments", HttpMethod.POST, new HttpEntity(paymentsRequest),
                new ParameterizedTypeReference<Payments>() {
                }).getBody();
    }
     
    public Payments getById(Long id){
        return restTemplate.exchange("http://localhost:8088/payments/"+id, HttpMethod.GET, null,
                new ParameterizedTypeReference<Payments>(){
                }).getBody();
    }
    
    public List<Payments> getByUsername(String username){
        return restTemplate.exchange("http://localhost:8088/payments/username?username="+username, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Payments>>(){
                }).getBody();
    }
    
    public Payments update(Long id, Payments payments){
        return restTemplate.exchange("http://localhost:8088/payments/"+id, HttpMethod.PUT, new HttpEntity(payments),
                new ParameterizedTypeReference<Payments>(){
                }).getBody();
    }
    public Payments delete(Long id){
        return restTemplate.exchange("http://localhost:8088/payments/"+id, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<Payments>(){
                }).getBody();
    }
    
    public Payments updateUser(Long id, MultipartFile file) throws IOException{

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        String gambar = Base64.getEncoder().encodeToString(file.getBytes());

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("file", gambar);

        HttpEntity<MultiValueMap<String, Object>> requestEntity= new HttpEntity<>(params, headers);

        return restTemplate.exchange("http://localhost:8088/payments/upload/"+id, HttpMethod.PUT, requestEntity,
                new ParameterizedTypeReference<Payments>(){
                }).getBody();
    }
    
    public List<String> buatStatus(){
        List<String> statusList = new ArrayList<String>();

        statusList.add("UNPAID");
        statusList.add("REVIEW");
        statusList.add("PAID");

        return statusList;
    }
}