package Q1373_2진수_8진수;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger num = new BigInteger(sc.next(), 2);
        System.out.println(num.toString(8));
    }
}
