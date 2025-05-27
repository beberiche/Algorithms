package Q3943_헤일스톤_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int ans = N;
            while (true) {
                ans = Math.max(ans, N);

                if ((N & (-N)) == N) {
                    break;
                }

                if (N % 2 == 0) {
                    N /= 2;
                } else {
                    N = N * 3 + 1;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
