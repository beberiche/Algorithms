package Q1497_기타콘서트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, ret;
    private static long max, a[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        a = new long[N];
        max = 0; // 최댓값
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            String name = stk.nextToken();
            String yn = stk.nextToken();
            long l = 0;
            for (int j = 0; j < M; j++) {
                char ch = yn.charAt(j);
                if (ch == 'Y') {
                    l |= 1L << (M - j - 1);
                }
            }
            max |= l;
            a[i] = l;
        }

        if (max == 0) {
            System.out.println(-1);
            return;
        }

        ret = N;
        pset(0, 0, 0);
        System.out.println(ret);
    }

    private static void pset(int cnt, int idx, long sum) {
        if (sum == max) {
            ret = Math.min(ret, cnt);
            return;
        }

        if (ret < cnt || idx >= N) return;

        pset(cnt, idx + 1, sum); // 안사고 넘어가는 경우
        pset(cnt + 1, idx + 1, sum | a[idx]); // 사고 넘어가는 경우
    }
}
