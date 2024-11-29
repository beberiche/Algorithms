package Q1350_진짜_공간;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] a = new long[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(stk.nextToken());
        }

        int cluster = Integer.parseInt(br.readLine());
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            if (a[i] == 0) continue;

            if (a[i] < cluster) {
                cnt++;
            } else if (a[i] >= cluster) {
                long div = a[i] / cluster;
                cnt += (a[i] % cluster == 0 ? div : div + 1);
            }
        }
        System.out.println(cnt * cluster);
    }
}
