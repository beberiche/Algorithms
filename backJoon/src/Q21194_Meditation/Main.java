package Q21194_Meditation;

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

        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(a);

        int sum = 0;
        for (int i = N - 1, j = M - 1; i >= 0 && j >= 0; i--, j--) {
            sum += a[i];
        }
        System.out.println(sum);
    }
}
