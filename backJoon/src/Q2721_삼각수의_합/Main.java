package Q2721_삼각수의_합;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += j * (j + 1) * (j + 2) / 2;
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
