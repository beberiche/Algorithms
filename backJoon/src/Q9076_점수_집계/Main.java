package Q9076_점수_집계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int[] a = new int[5];
            for (int j = 0; j < 5; j++) {
                a[j] = Integer.parseInt(stk.nextToken());
            }
            Arrays.sort(a);
            sb.append(a[3] - a[1] >= 4 ? "KIN" : a[1] + a[2] + a[3]).append("\n");
        }
        System.out.print(sb);
    }
}
