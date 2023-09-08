package com.itheima.module2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.NumberFormat;

@Controller
public class CalController {
    @RequestMapping("/cal")
    @ResponseBody
    String[] cal(double yr, double p, int m, int type) {
        if (type == 0) {
            double mr = yr / 12.0 / 100;
            double pow = Math.pow(1 + mr, m);
            double payment = p * mr * pow / (pow - 1);
            return new String[]{
                    NumberFormat.getCurrencyInstance().format(payment * m),
                    NumberFormat.getCurrencyInstance().format(payment * m - p)
            };
        } else {
            double payPrincipal = p / m;
            double backup = p;
            double mr = yr / 12.0 / 100;
            double payInterestTotal = 0.0;
            for (int i = 0; i < m; i++) {
                double payInterest = p * mr;
                p -= payPrincipal;
                payInterestTotal += payInterest;
            }
            return new String [] {
                    NumberFormat.getCurrencyInstance().format(backup + payInterestTotal),
                    NumberFormat.getCurrencyInstance().format(payInterestTotal)
            };
        }




    }

    @RequestMapping("/details")
    @ResponseBody
    String[][] details(double yr, double p, int m, int type) {
        if (type == 0) {
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
        } else {
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
    }
}
