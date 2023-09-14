package com.Ian.module4.controller;

import com.Ian.module4.dto.Calculator;
import com.Ian.module4.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculatorController {

    @Autowired
    CalculatorService[] array;


    @RequestMapping("/cal")
    @ResponseBody
    String[] cal(Calculator c, int type) {
        CalculatorService service = array[type];
        return service.cal(c);
    }

    @RequestMapping("/details")
    @ResponseBody
    String[][] details(Calculator c, int type) {
        CalculatorService service = array[type];
        return service.details(c);
    }
}
