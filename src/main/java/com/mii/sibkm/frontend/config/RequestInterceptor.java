/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sibkm.frontend.config;


import java.io.IOException;
import com.mii.sibkm.frontend.util.BasicHeader;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
/**
 *
 * @author khali
 */
public class RequestInterceptor implements ClientHttpRequestInterceptor{
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        if (!request.getURI().getPath().equals("/login")) {
            request.getHeaders().add("Authorization", BasicHeader.createHeaders());
        }
        ClientHttpResponse response = execution.execute(request, body);
        return response;
    }
}
