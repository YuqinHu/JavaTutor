package com.ian.module3;

import java.text.NumberFormat;

public class Calculator0 extends Calculator{


    public Calculator0(double p, int m, double yr) {
        super(p, m, yr);
    }

    String[] cal0() {
        double mr = yr / 12.0 / 100;
        double pow = Math.pow(1 + mr, m);
        double payment = p * mr * pow / (pow - 1);
        return new String[]{
                NumberFormat.getCurrencyInstance().format(payment * m),
                NumberFormat.getCurrencyInstance().format(payment * m - p)
        };
    }
    String[][] details0() {
        String[][] a2 = new String[m][];

        double mr = yr / 12.0 / 100;
        double pow = Math.pow(1 + mr, m);
        double payment = p * mr * pow / (pow - 1);
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr;
            double payPrincipal = payment - payInterest;
            p -= payPrincipal;
            a2[i] = createRow(i, payment, payPrincipal, payInterest);
        }
        return a2;
    }

}


