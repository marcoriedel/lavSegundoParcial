package com.utn.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Call {

    private Integer id;

    private double duration;

    private double amount;

    private Date createdOn;



}
