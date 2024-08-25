package Q24508_나도리팡;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int T = Integer.parseInt(stk.nextToken());

        Integer[] a = new Integer[N];
        long sum = 0;

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
            sum += a[i];
        }

        if (sum % K != 0) {
            System.out.println("NO");
            return;
        }


        Arrays.sort(a, Comparator.reverseOrder());

        long cnt = 0;
        for (int i = 0; i < sum / K; i++) {
            cnt += K - a[i];
        }

        System.out.println( cnt <= T ? "YES" : "NO");

    }
}
