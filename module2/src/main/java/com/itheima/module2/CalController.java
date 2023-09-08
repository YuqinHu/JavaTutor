package com.itheima.module2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.NumberFormat;

@Controller
public class CalController {

    static void check(double p, int m, double yr, int type) {
        if (p <= 0) {
            throw new IllegalArgumentException("capital should more than 0");
        }
        if (m < 1 || m > 360) {
            throw new IllegalArgumentException("month should between 1 and 360");
        }
        if (yr < 1.0 || yr > 36.0) {
            throw new IllegalArgumentException("interest rate/year should between 1 and 36");
        }
        if (type !=0 && type != 1) {
            throw new IllegalArgumentException("error");
        }
    }

    static String[] cal0(double p, int m, double yr) {
        double mr = yr / 12.0 / 100;
        double pow = Math.pow(1 + mr, m);
        double payment = p * mr * pow / (pow - 1);
        return new String[]{
                NumberFormat.getCurrencyInstance().format(payment * m),
                NumberFormat.getCurrencyInstance().format(payment * m - p)
        };
    }

    @RequestMapping("/cal")
    @ResponseBody
    String[] cal(double yr, double p, int m, int type) {
        check(p, m, yr, type);
        if (type == 0) {
            return cal0(p, m, yr);
        } else {
            return cal1(yr, p, m);
        }




    }

    private static String[] cal1(double yr, double p, int m) {
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

    @RequestMapping("/details")
    @ResponseBody
    String[][] details(double yr, double p, int m, int type) {
        check(p, m, yr, type);
        if (type == 0) {
            return details0(yr, p, m);
        } else {
            return details1(yr, p, m);
        }
    }

    private static String[][] details1(double yr, double p, int m) {
        String[][] a2 = new String[m][];
        double payPrincipal = p / m;
        double mr = yr / 12.0 / 100;
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr;
            p -= payPrincipal;
            double payment = payPrincipal + payInterest;
            String[] row = new String[] {
                    (i + 1) + "",
                    NumberFormat.getCurrencyInstance().format(payment),
                    NumberFormat.getCurrencyInstance().format(payPrincipal),
                    NumberFormat.getCurrencyInstance().format(payInterest),
                    NumberFormat.getCurrencyInstance().format(p)
            };
            a2[i] = row;
        }
        return a2;
    }

    private static String[][] details0(double yr, double p, int m) {
        String[][] a2 = new String[m][];

        double mr = yr / 12.0 / 100;
        double pow = Math.pow(1 + mr, m);
        double payment = p * mr * pow / (pow - 1);
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr;
            double payPrincipal = payment - payInterest;
            p -= payPrincipal;
            String[] row = new String[]{
                    (i + 1) + "",
                    NumberFormat.getCurrencyInstance().format(payment),
                    NumberFormat.getCurrencyInstance().format(payPrincipal),
                    NumberFormat.getCurrencyInstance().format(payInterest),
                    NumberFormat.getCurrencyInstance().format(p)
            };
            a2[i] = row;
        }
        return a2;
    }
}
