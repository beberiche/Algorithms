package Q23829_인문예술탐사구간;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, a[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        int Q = Integer.parseInt(stk.nextToken());

        a = new int[N + 1];
        long[] sum = new long[N + 1];

        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(a);

        for(int i=1; i<=N; i++) {
            sum[i] = sum[i-1] + a[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            int idx = lowerBound(q);

            long leftSum = ((long) idx * q) - sum[idx];
            long rightSum = sum[N] - sum[idx] - ((long) (N - idx) * q);
            sb.append(leftSum+rightSum).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int lowerBound(int q) {
        int l = 0;
        int r = N;

        int ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] > q) {
                r = mid - 1;
            } else {
                ans = mid;
                l = mid + 1;
            }
        }

        return ans;
    }
}
