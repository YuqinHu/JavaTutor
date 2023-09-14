package com.Ian.module4.service.impl;

import com.Ian.module4.dto.Calculator;
import com.Ian.module4.service.CalculatorService;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculatorService0 implements CalculatorService {

    public CalculatorService0() {
        System.out.println("service0 created");
    }
    @Override
    public String[] cal(Calculator c) {
        double yr = c.getYr();
        int m = c.getM();
        double p = c.getP();

        double mr = yr / 12.0 / 100;
        double pow = Math.pow(1 + mr, m);
        double payment = p * mr * pow / (pow - 1);
        return new String[]{
                NumberFormat.getCurrencyInstance().format(payment * m),
                NumberFormat.getCurrencyInstance().format(payment * m - p)
        };
    }

    @Override
    public String[][] details(Calculator c) {
        double yr = c.getYr();
        int m = c.getM();
        double p = c.getP();

        String[][] a2 = new String[m][];

        double mr = yr / 12.0 / 100;
        double pow = Math.pow(1 + mr, m);
        double payment = p * mr * pow / (pow - 1);
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr;
            double payPrincipal = payment - payInterest;
            p -= payPrincipal;
            a2[i] = createRow(i, payment, payPrincipal, payInterest, p);
        }
        return a2;
    }

}
