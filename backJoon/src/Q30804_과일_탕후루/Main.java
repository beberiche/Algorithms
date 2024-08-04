package Q30804_과일_탕후루;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        int[] a = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }

        int l = 0;
        int r = 0;
        int size = 1;
        int[] cnt = new int[10];
        cnt[a[r]]++;
        int ans = size;
        while (l < N && r < N) {
            if (size <= 2) {
                ans = Math.max(r - l + 1, ans);
                r++;
                if (r < N && cnt[a[r]]++ == 0) size++;
            } else {
                if (--cnt[a[l++]] == 0) size--;
            }
        }

        System.out.println(ans);
    }
}
