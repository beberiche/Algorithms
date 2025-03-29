package Q2863_이게_분수;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();

        double zero = a / c + b / d;
        double one = c / d + a / b;
        double two = d / b + c / a;
        double three = b / a + d / c;

        if ((zero >= one) && (zero >= two) && (zero >= three)) {
            System.out.println(0);
        } else if ((one >= zero) && (one >= two) && (one >= three)) {
            System.out.println(1);
        } else if ((two >= zero) && (two >= one) && (two >= three)) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }
    }
}
