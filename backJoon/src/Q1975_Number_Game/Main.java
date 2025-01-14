package Q1975_Number_Game;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int cnt = 0;
            int N = Integer.parseInt(br.readLine());
            for (int j = 2; j <= N; j++) {
                int num = N;
                while (true) {
                    if (num % j != 0) break;
                    cnt++;
                    num /= j;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
