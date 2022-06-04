package Q2811_소수와합성수;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int n = sc.nextInt();
            if (n == 1) {
                System.out.println("number one");
            } else if (check(n)) {
                System.out.println("prime number");
            } else {
                System.out.println("composite number");
            }
        }
    }

    private static boolean check(int n) {
        for(int i=2; i<=(int)Math.sqrt(n); i++) {
            if(n%i==0) 
                return false;
        }
        return true;
    }
}
