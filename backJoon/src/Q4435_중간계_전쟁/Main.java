package Q4435_중간계_전쟁;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int N = 6; // 간달프의 병사 수
        int M = 7; // 사우론의 병사 수
        int[] a1 = new int[N]; // 간달프
        int[] a2 = new int[M]; // 사우론
        a1[0] = 1;
        a1[1] = 2;
        a1[2] = 3;
        a1[3] = 3;
        a1[4] = 4;
        a1[5] = 10;

        a2[0] = 1;
        a2[1] = 2;
        a2[2] = 2;
        a2[3] = 2;
        a2[4] = 3;
        a2[5] = 5;
        a2[6] = 10;

        StringBuilder sb = new StringBuilder();
        String s1 = "Good triumphs over Evil";
        String s2 = "Evil eradicates all trace of Good";
        String s3 = "No victor on this battle field";
        for (int t = 1; t <= T; t++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int sum1 = 0; // 간달프 측 총력
            int sum2 = 0; // 사우론 측 총력

            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(stk.nextToken());
                sum1 += a1[i] * x;
            }

            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int x = Integer.parseInt(stk.nextToken());
                sum2 += a2[i] * x;
            }

            sb.append("Battle ").append(t).append(": ");
            if (sum1 > sum2) {
                sb.append(s1);
            } else if (sum1 < sum2) {
                sb.append(s2);
            } else {
                sb.append(s3);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
