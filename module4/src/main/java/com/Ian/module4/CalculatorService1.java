package com.Ian.module4;

import java.text.NumberFormat;

public class CalculatorService1 {
    String[] cal(Calculator c) {
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

    String[][] details(Calculator c) {
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

    String[] createRow(int i, double payment, double payPrincipal, double payInterest, double p) {
        String[] row = new String[]{
                (i + 1) + "",
                NumberFormat.getCurrencyInstance().format(payment),
                NumberFormat.getCurrencyInstance().format(payPrincipal),
                NumberFormat.getCurrencyInstance().format(payInterest),
                NumberFormat.getCurrencyInstance().format(p)
        };

        return row;
    }
}
