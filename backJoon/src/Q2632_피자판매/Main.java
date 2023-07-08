package Q2632_피자판매;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K, M, N, a[], b[], acnt[], bcnt[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());
        a = new int[M * 2 + 1];
        b = new int[N * 2 + 1];

        for (int i = 1; i <= M; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= N; i++) {
            b[i] = Integer.parseInt(br.readLine());
        }
        for (int i = M + 1; i <= M * 2; i++) {
            a[i] = a[i - M];
        }

        for (int i = N + 1; i <= N * 2; i++) {
            b[i] = b[i - N];
        }
    }

    private static void getCntArr(int[] arr, int[] cnt) {
        for (int i = 1; i <= arr.length / 2; i++) {
            int ret = 0;
            for (int j = 1; j <= i; j++) {
                ret += arr[j];
            }
            if (ret <= K) cnt[ret]++;

            if (i >= arr.length / 2) break;
            for (int j = i + 1; j <= (arr.length / 2) + i - 1; j++) {
                ret -= arr[j - i];
                ret += arr[j];
                if (ret <= K) cnt[ret]++;
            }
        }
    }

    private static void solve() {
        acnt = new int[K+1];
        bcnt = new int[K+1];
        getCntArr(a, acnt);
        getCntArr(b, bcnt);
    }


    private static void output() {
        int ret = 0;
        ret = acnt[K] + bcnt[K];
        for (int i = 1; i < K; i++) {
            ret += acnt[i] * bcnt[K - i];
        }
        System.out.println(ret);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}