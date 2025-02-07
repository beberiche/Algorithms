package Q2445_별_찍기_8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 1; j <= N - i; j++) {
                sb.append("*");
            }

            for (int j = 1; j <= 2 * i; j++) {
                sb.append(" ");
            }

            for (int j = 1; j <= N - i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                sb.append("*");
            }

            for (int j = 1; j <= 2 * i; j++) {
                sb.append(" ");
            }

            for (int j = 1; j <= N - i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}