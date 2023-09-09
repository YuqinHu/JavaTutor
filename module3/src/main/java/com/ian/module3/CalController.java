package com.ian.module3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.NumberFormat;

@Controller
public class CalController {

    static void check(double p, int m, double yr, int type) {
        if (p <= 0) {
            throw new IllegalArgumentException("capital should more than 0");
        }
        if (m < 1 || m > 360) {
            throw new IllegalArgumentException("month should between 1 and 360");
        }
        if (yr < 1.0 || yr > 36.0) {
            throw new IllegalArgumentException("interest rate/year should between 1 and 36");
        }
        if (type !=0 && type != 1) {
            throw new IllegalArgumentException("error");
        }
    }

    @RequestMapping("/cal")
    @ResponseBody
    String[] cal(double yr, double p, int m, int type) {
        check(p, m, yr, type);
        if (type == 0) {
            Calculator0 c0 = new Calculator0(p, m, yr);
            return c0.cal0();
        } else {
            Calculator1 c1 = new Calculator1(p, m, yr);
            return c1.cal1();
        }




    }

    @RequestMapping("/details")
    @ResponseBody
    String[][] details(double yr, double p, int m, int type) {
        check(p, m, yr, type);
        if (type == 0) {
            Calculator0 c0 = new Calculator0(p, m, yr);
            return c0.details0();
        } else {
            Calculator1 c1 = new Calculator1(p, m, yr);
            return c1.details1();
        }
    }

}
