package Q10996_별_찍기_21;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 2 * N; i++) {
            if (i % 2 == 1) { // 홀수 줄
                for (int j = 0; j < N; j++) {
                    sb.append(j % 2 == 0 ? "*" : " ");
                }
            } else { // 짝수 줄
                for (int j = 0; j < N; j++) {
                    sb.append(j % 2 == 0 ? " " : "*");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
