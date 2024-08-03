package Q1495_기타리스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int S = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] dp = new int[M + 1];

        Arrays.fill(dp, -1);
        dp[S] = 0;

        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int vol = Integer.parseInt(stk.nextToken());
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= M; j++) {
                if (dp[j] == i - 1) {
                    int ret1 = j + vol;
                    int ret2 = j - vol;

                    if (ret1 <= M) {
                        list.add(ret1);
                    }
                    if (ret2 >= 0) {
                        list.add(ret2);
                    }
                }
            }

            for (int n : list) {
                dp[n] = i;
            }
        }

        int max = -1;
        for (int i = 0; i <= M; i++) {
            if (dp[i] == N) {
                max = Math.max(max, i);
            }
        }
        System.out.println(max);
    }


}
