package Q2525_오븐시계;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        int ct = sc.nextInt();

        int sumM = ct + M;
        while(sumM > 59) {
            H++;
            sumM-=60;
        }
        while(H>23) {
            H-=24;
        }
        System.out.println(H + " " + sumM);
    }
}
