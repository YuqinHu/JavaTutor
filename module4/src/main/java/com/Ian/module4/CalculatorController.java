package com.Ian.module4;

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
    String[] cal(double p, int m, double yr, int type) {
        CalculatorService service = array[type];
        return service.cal(new Calculator(p, m, yr));
    }

    @RequestMapping("/details")
    @ResponseBody
    String[][] details(double yr, double p, int m, int type) {
        CalculatorService service = array[type];
        return service.details(new Calculator(p, m, yr));
    }
}
