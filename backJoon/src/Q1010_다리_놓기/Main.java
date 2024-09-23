package Q1010_다리_놓기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(stk.nextToken());
        StringBuilder sb = new StringBuilder();
        while (--T >= 0) {
            stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());

            int cnt = 1;
            long result = 1;
            for (int i = M; i > M - N; i--) {
                result *= i;
                result /= cnt++;
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb.toString());
    }
}
