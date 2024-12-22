package Q1731_추론;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int ret = a[2] - a[1] == a[1] - a[0] ? a[N - 1] + (a[1] - a[0]) : a[N-1] * (a[1]/a[0]);

        System.out.println(ret);
    }
}
