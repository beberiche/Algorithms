package Q2491_수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int cnt1 = 1;
        int cnt2 = 1;
        int ret = 1;
        a[0] = Integer.parseInt(stk.nextToken());
        for (int i = 1; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
            if (a[i - 1] <= a[i]) {
                cnt1++;
            } else {
                cnt1 = 1;
            }

            if (a[i - 1] >= a[i]) {
                cnt2++;
            } else {
                cnt2 = 1;
            }

            ret = Math.max(ret, Math.max(cnt1, cnt2));
        }

        System.out.println(ret);
    }
}
