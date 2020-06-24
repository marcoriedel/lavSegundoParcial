package com.utn.demo.service.integration;

import com.utn.demo.model.Call;
import com.utn.demo.model.LoginInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class IntegrationComponent {

    private RestTemplate rest;
    private static String loginUser = "http://localhost:8080/login";
    private static String url = "http://localhost:8080/api/Call/lastCallByDni/";

    @PostConstruct
    private void init() {
        rest = new RestTemplateBuilder()
                .build();
    }


    public Call getCallByDni(Integer dni) {
        url = url+dni;
        return rest.getForObject(url,Call.class);
    }

    public ResponseEntity loginUser(@RequestBody LoginInput loginInput){
        HttpEntity<LoginInput> request = new HttpEntity<LoginInput>(loginInput);


        ResponseEntity response = rest.postForEntity(loginUser,request,String.class);
        HttpHeaders header = response.getHeaders();

        System.out.println(header.get("Authorization"));
        return response;

    }

}
