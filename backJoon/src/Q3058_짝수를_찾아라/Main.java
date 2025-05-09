package Q3058_짝수를_찾아라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int min = 100;
            int sum = 0;
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                int N = Integer.parseInt(stk.nextToken());
                if (N % 2 == 0) {
                    sum += N;
                    min = Math.min(min, N);
                }
            }
            sb.append(sum).append(" ").append(min).append("\n");
        }
        System.out.print(sb);
    }
}
