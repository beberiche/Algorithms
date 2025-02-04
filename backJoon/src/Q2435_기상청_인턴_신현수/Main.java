package Q2435_기상청_인턴_신현수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] a = new int[103];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= N - M; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += a[i + j];
            }

            if (sum > max) max = sum;
        }

        System.out.println(max);
    }
}
