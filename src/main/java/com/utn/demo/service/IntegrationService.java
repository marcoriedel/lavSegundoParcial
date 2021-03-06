package com.utn.demo.service;

import com.utn.demo.model.Call;
import com.utn.demo.model.LoginInput;
import com.utn.demo.service.integration.IntegrationComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class IntegrationService {

    @Autowired
    IntegrationComponent integrationComponent;

    public Call getCallByDni(Integer dni){
        return integrationComponent.getCallByDni(dni);
    }

    public ResponseEntity login(LoginInput loginInput) {
        return integrationComponent.loginUser(loginInput);
    }
}
