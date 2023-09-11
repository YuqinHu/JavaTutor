package com.Ian.module4;

import java.text.NumberFormat;

public class CalculatorService0 {
    String[] cal(Calculator c) {
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

    String[][] details(Calculator c) {
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
