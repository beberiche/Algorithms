package Q2229_조_짜기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N + 1];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }


        int dp[] = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            int max = arr[i];
            int min = arr[i];
            for (int j = i-1; j >= 1; j--) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);

                dp[i] = Math.max(dp[i], dp[j-1] + max - min);
            }
        }
        System.out.println(dp[N]);
    }
}
