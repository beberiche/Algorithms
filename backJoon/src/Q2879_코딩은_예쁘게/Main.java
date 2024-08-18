package Q2879_코딩은_예쁘게;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken()) - a[i];
        }
        int cnt = 0;

        int prev = a[0];

        if (N == 1) {
            System.out.println(Math.abs(prev));
            return;
        }

        for (int i = 1; i < N; i++) {
            if (prev * a[i] < 0) {
                cnt += Math.abs(prev);
            } else if (Math.abs(prev) >= Math.abs(a[i])) {
                cnt += Math.abs(prev) - Math.abs(a[i]);
            }
            prev = a[i];
        }

        cnt += Math.abs(prev);

        System.out.println(cnt);
    }

}
