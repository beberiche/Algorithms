package Q1183_약속;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N % 2 == 1) {
            System.out.print(1);
            return;
        }

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int promise = Integer.parseInt(stk.nextToken());
            int goal = Integer.parseInt(stk.nextToken());
            a[i] = promise - goal;
        }

        Arrays.sort(a);
        int n1 = a[N / 2 - 1];
        int n2 = a[N / 2];
        int result = n2 - n1 + 1;
        System.out.println(result);
    }
}
