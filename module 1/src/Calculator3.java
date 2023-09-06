import java.text.NumberFormat;
import java.util.Scanner;

public class Calculator3 {
    public static void main(String[] args) {
        double p = inputCheckP() ;
        double mr = inputCheckMr();
        int month = inputCheckM();
        double payment = calculate(p, mr, month);

        printDetails(p, mr, month, payment);
    }

    static double inputCheckP() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter capital");
        double p = scanner.nextDouble();
        if (p <= 0) {
            throw new IllegalArgumentException("capital should more than 0");
        }
        return p;
    }

    static double inputCheckMr() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter interest rate/year");
        double year = scanner.nextDouble();
        if (year < 1.0 || year > 36.0) {
            throw new IllegalArgumentException("interest rate/year should between 1 and 36");
        }
        return year / 12.0 / 100;
    }

    static int inputCheckM() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter number of month");
        int month = scanner.nextInt();
        if (month < 1 || month > 360) {
            throw new IllegalArgumentException("month should between 1 and 360");
        }
        return month;
    }

    static void printDetails(double p, double mr, int month, double payment) {
        for(int i = 0; i < month; i++) {
            double payInterest = p * mr;
            double payPrincipal = payment - payInterest;
            p -= payPrincipal;
            System.out.println("month:" + (i+1));
            System.out.println("\tpay this month:" + NumberFormat.getCurrencyInstance().format(payment));
            System.out.println("\tpay capital:" + NumberFormat.getCurrencyInstance().format(payPrincipal));
            System.out.println("\tpay interest:" + NumberFormat.getCurrencyInstance().format(payInterest));
            System.out.println("\trest of capital" + NumberFormat.getCurrencyInstance().format(p));
        }
        System.out.println("total payment" + NumberFormat.getCurrencyInstance().format(payment * month));
    }

    static double calculate(double p, double mr, int m) {
        double pow = Math.pow(1 + mr, m);
        return p * mr * pow / (pow - 1);
    }
}
