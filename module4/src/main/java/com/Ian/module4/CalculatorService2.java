package com.Ian.module4;

import java.text.NumberFormat;

public class CalculatorService2 {
    String[] cal(Calculator c) {
        double p = c.getP();

        return new String[] {
                NumberFormat.getCurrencyInstance().format(p),
                "0"
        };
    }

    String[][] details(Calculator c) {
        int m = c.getM();
        double p = c.getP();

        String[][] a2 = new String[m][];
        double payment = p/m;
        for(int i = 0; i < m; i ++) {
            p -= payment;
            a2[i] = createRow(i, payment, payment, 0, p);
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
