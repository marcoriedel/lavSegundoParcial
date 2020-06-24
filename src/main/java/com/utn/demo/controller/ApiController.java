package com.utn.demo.controller;

import com.utn.demo.model.Call;
import com.utn.demo.model.LoginInput;
import com.utn.demo.service.IntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    IntegrationService integrationService;

    @GetMapping("/callbydni/{dni}")
    public ResponseEntity <Call> getCall(@PathVariable Integer dni) throws Exception {
        try {
            Call call = integrationService.getCallByDni(dni);
            return !(isNull(call)) ? ResponseEntity.ok(call) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

   @PostMapping("/login")
   public ResponseEntity login(@RequestBody LoginInput loginInput) throws Exception {

        try {
             return integrationService.login(loginInput);

        } catch (Exception e) {
            e.printStackTrace();
        }
       return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
   }

}
