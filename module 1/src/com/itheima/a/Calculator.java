package com.itheima.a;

import java.text.NumberFormat;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter capital");
        double p = scanner.nextDouble();
        if (p <= 0) {
            System.out.println("capital should more than 0");
            return;
        }

        System.out.println("please enter interest rate/year");
        double year = scanner.nextDouble();
        if (year < 1.0 || year > 36.0) {
            System.out.println("interest rate/year should between 1 and 36");
            return;
        }

        double mr = year / 12.0 / 100;
        System.out.println("please enter number of month");
        int month = scanner.nextInt();
        if (month < 1 || month > 360) {
            System.out.println("month should between 1 and 360");
            return;
        }

        double pow = Math.pow(1 + mr, month);
        double payment = p * mr * pow / (pow - 1);
        System.out.println(NumberFormat.getCurrencyInstance().format(payment));

        for(int i = 0; i < month; i++) {
            double payInterest = p * mr;
            double payPrincipal = payment - payInterest;
            p -= payPrincipal;
            System.out.println("month:" + (i+1));
            System.out.println("pay this month:" + NumberFormat.getCurrencyInstance().format(payment));
            System.out.println("pay capital:" + NumberFormat.getCurrencyInstance().format(payPrincipal));
            System.out.println("pay interest:" + NumberFormat.getCurrencyInstance().format(payInterest));
            System.out.println("rest of capital" + NumberFormat.getCurrencyInstance().format(p));
        }
        System.out.println("total payment" + NumberFormat.getCurrencyInstance().format(payment * month));
    }
}
