package com.ian.module3;

import java.text.NumberFormat;

public class Calculator2 extends Calculator{

    public Calculator2(double p, int m, double yr) {
        super(p, m, yr);
    }

    @Override
    String[] cal() {
        return new String[] {
                NumberFormat.getCurrencyInstance().format(p),
                "0"
        };
    }

    @Override
    String[][] details() {
        String[][] a2 = new String[m][];
        double payment = p/m;
        for(int i = 0; i < m; i ++) {
            p -= payment;
            a2[i] = createRow(i, payment, payment, 0);
        }
        return a2;
    }
}
