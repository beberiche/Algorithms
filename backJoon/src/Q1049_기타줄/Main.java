package Q1049_기타줄;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] a = new int[M]; // 팩
        int[] b = new int[M]; // 한개씩
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(stk.nextToken());
            b[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int ret = (int) 1e6;

        int ret1 = (N % 6 == 0 ? N / 6 : N / 6 + 1) * a[0]; // 가장 싼 팩 모두 구매
        int ret2 = N * b[0]; // 가장 싼 낱개 모두 구매
        int ret3 = N / 6 * a[0] + N % 6 * b[0]; // 싼 팩 구매 후, 나머지 낱개 구매

        ret = Math.min(ret1, Math.min(ret2, ret3));
        System.out.println(ret);
    }
}
