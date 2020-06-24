package com.utn.demo.service.integration;

import com.utn.demo.model.Call;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class IntegrationComponent {

    private RestTemplate rest;
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
}
