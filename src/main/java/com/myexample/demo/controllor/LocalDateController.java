package com.myexample.demo.controllor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class LocalDateController {

    @RequestMapping("/date/{localDate}")
    public String get(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate localDate){
        return localDate.toString();
    }
}
