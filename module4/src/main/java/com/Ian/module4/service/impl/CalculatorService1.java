package com.Ian.module4.service.impl;

import com.Ian.module4.dto.Calculator;
import com.Ian.module4.service.CalculatorService;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculatorService1 implements CalculatorService {

    public CalculatorService1() {
        System.out.println("service1 created");
    }
    @Override
    public String[] cal(Calculator c) {
        double yr = c.getYr();
        int m = c.getM();
        double p = c.getP();

        double payPrincipal = p / m;
        double backup = p;
        double mr = yr / 12.0 / 100;
        double payInterestTotal = 0.0;
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr;
            p -= payPrincipal;
            payInterestTotal += payInterest;
        }
        return new String[]{
                NumberFormat.getCurrencyInstance().format(backup + payInterestTotal),
                NumberFormat.getCurrencyInstance().format(payInterestTotal)
        };
    }

    @Override
    public String[][] details(Calculator c) {
        double yr = c.getYr();
        int m = c.getM();
        double p = c.getP();

        String[][] a2 = new String[m][];
        double payPrincipal = p / m;
        double mr = yr / 12.0 / 100;
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr;
            p -= payPrincipal;
            double payment = payPrincipal + payInterest;
            a2[i] = createRow(i, payment, payPrincipal, payInterest, p);
        }
        return a2;
    }


}
