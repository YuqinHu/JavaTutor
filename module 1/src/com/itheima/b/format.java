package com.itheima.b;

import java.text.NumberFormat;

public class format {
    public static void main(String[] args) {
        String format = NumberFormat.getCurrencyInstance().format(11991.010503055139);
        System.out.println(format);
    }
}
