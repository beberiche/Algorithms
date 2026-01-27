package Q20551_Sort_마스터_배지훈의_후계자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(a);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());

            int l = 0;
            int r = N;

            while (l < r) {
                int mid = (l + r) >> 1;
                if (num <= a[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            boolean check = r >= N || a[r] != num;
            sb.append(check ? -1 : r).append("\n");
        }
        System.out.print(sb);
    }
}
