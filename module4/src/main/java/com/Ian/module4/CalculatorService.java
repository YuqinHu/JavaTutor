package com.Ian.module4;

import java.text.NumberFormat;


public interface CalculatorService {


    String[] cal(Calculator c);


    String[][] details(Calculator c);
    default String[] createRow(int i, double payment, double payPrincipal, double payInterest, double p) {

        return new String[]{
                (i + 1) + "",
                NumberFormat.getCurrencyInstance().format(payment),
                NumberFormat.getCurrencyInstance().format(payPrincipal),
                NumberFormat.getCurrencyInstance().format(payInterest),
                NumberFormat.getCurrencyInstance().format(p)
        };
    }
}
