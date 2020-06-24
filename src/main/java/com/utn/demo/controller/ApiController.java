package com.utn.demo.controller;

import com.utn.demo.model.Call;
import com.utn.demo.service.IntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    IntegrationService integrationService;

    @GetMapping("/callbydni/{dni}")
    public Call getCall(@PathVariable Integer dni) {
        return integrationService.getCallByDni(dni);
    }
}
