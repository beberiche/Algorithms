package Q27210_신을_모시는_사당;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 1 기준
        int dp1[] = new int[N + 1];
        // 2 기준
        int dp2[] = new int[N + 1];

        int ans = Integer.MIN_VALUE;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(stk.nextToken());

            int curr = num == 1 ? 1 : -1;
            dp1[i] = Math.max(dp1[i - 1] + curr, curr);

            ans = Math.max(ans, dp1[i]);

            curr = num == 1 ? -1 : 1;
            dp2[i] = Math.max(dp2[i - 1] + curr, curr);

            ans = Math.max(ans, dp2[i]);
        }

        System.out.println(ans);

    }
}
