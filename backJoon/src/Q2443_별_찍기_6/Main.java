package Q2443_별_찍기_6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            // 빈칸 생성
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }

            // 별 찍기
            for (int j = 0; j < 2 * (N - i) - 1; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }
}
