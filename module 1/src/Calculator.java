import java.text.NumberFormat;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter capital");
        double p = scanner.nextDouble();
        System.out.println("please enter interest rate");
        double year = scanner.nextDouble();
        double mr = year / 12.0 / 100;
        System.out.println("please enter number of month");
        int month = scanner.nextInt();
        double pow = Math.pow(1 + mr, month);
        double payment = p * mr * pow / (pow - 1);
        System.out.println(NumberFormat.getCurrencyInstance().format(payment));
    }
}
