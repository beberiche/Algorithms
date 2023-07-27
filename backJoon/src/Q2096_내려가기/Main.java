package Q2096_내려가기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MAX, MIN, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(stk.nextToken());
        int n2 = Integer.parseInt(stk.nextToken());
        int n3 = Integer.parseInt(stk.nextToken());
        int[] dp_min = new int[]{n1, n2, n3};
        int[] dp_max = new int[]{n1, n2, n3};
        for (int i = 1; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(stk.nextToken());
            n2 = Integer.parseInt(stk.nextToken());
            n3 = Integer.parseInt(stk.nextToken());

            int dp_0 = Math.min(dp_min[0], dp_min[1]) + n1;
            int dp_1 = Math.min(dp_min[0], Math.min(dp_min[1], dp_min[2])) + n2;
            int dp_2 = Math.min(dp_min[1], dp_min[2]) + n3;

            int dp_3 = Math.max(dp_max[0], dp_max[1]) + n1;
            int dp_4 = Math.max(dp_max[0], Math.max(dp_max[1], dp_max[2])) + n2;
            int dp_5 = Math.max(dp_max[1], dp_max[2]) + n3;

            dp_min = new int[]{dp_0, dp_1, dp_2};
            dp_max = new int[]{dp_3, dp_4, dp_5};
        }

        MIN = Math.min(dp_min[0], Math.min(dp_min[1], dp_min[2]));
        MAX = Math.max(dp_max[0], Math.max(dp_max[1], dp_max[2]));
        System.out.print(MAX + " " + MIN);
    }
}
