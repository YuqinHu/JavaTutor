package com.ian.module3;

import java.text.NumberFormat;

public class Calculator1 extends Calculator {


    public Calculator1(double p, int m, double yr) {
        super(p, m, yr);
    }

    @Override
    String[] cal() {
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
    String[][] details() {
        String[][] a2 = new String[m][];
        double payPrincipal = p / m;
        double mr = yr / 12.0 / 100;
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr;
            p -= payPrincipal;
            double payment = payPrincipal + payInterest;
            a2[i] = createRow(i, payment, payPrincipal, payInterest);
        }
        return a2;
    }
}
