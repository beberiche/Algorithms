package Q1015_수열_정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] a = new int[N][3];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i][0] = Integer.parseInt(stk.nextToken());
            a[i][1] = i;
        }

        Arrays.sort(a, (n1, n2) -> {
            if (n1[0] == n2[0]) return n1[1] - n2[1];
            return n1[0] - n2[0];
        });

        for (int i = 0; i < N; i++) {
            a[i][2] = i;
        }

        Arrays.sort(a, (n1, n2) -> n1[1] - n2[1]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(a[i][2]).append(" ");
        }
        System.out.print(sb.toString());
    }
}
