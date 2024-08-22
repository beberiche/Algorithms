package Q30685_버터_녹이기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] a = new long[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            a[i][0] = Long.parseLong(stk.nextToken());
            a[i][1] = Long.parseLong(stk.nextToken());
        }

        Arrays.sort(a, (n1, n2) -> Long.compare(n1[0], n2[0]));

        int INF = (int) 1e9 - 1;
        int l = 0;
        int r = INF;

        int ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;

            int cnt = 0;
            for (int i = 0; i < N - 1; i++) {
                long x = a[i][0] + Math.min(a[i][1] / 2, mid);
                long y = a[i + 1][0] - Math.min(a[i + 1][1] / 2, mid);

                if (x < y) cnt++;
            }

            if (cnt == N - 1) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans == INF ? "forever":ans);
    }
}
