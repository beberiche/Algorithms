package Q9184_신나는_함수_실행;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int dp[][][] = new int[21][21][21];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            int n3 = Integer.parseInt(stk.nextToken());

            if (n1 == -1 && n2 == -1 && n3 == -1) break;

            sb.append("w(").append(n1).append(", ").append(n2).append(", ").append(n3).append(")").append(" = ").append(recur(n1, n2, n3)).append("\n");
        }
        System.out.print(sb.toString());
    }


    private static int recur(int a, int b, int c) {
        if (0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20 && dp[a][b][c] != 0) return dp[a][b][c];

        if (a <= 0 || b <= 0 || c <= 0) return 1;

        if (a > 20 || b > 20 || c > 20) return dp[20][20][20] = recur(20, 20, 20);

        if (a < b && b < c) return dp[a][b][c] = recur(a, b, c - 1) + recur(a, b - 1, c - 1) - recur(a, b - 1, c);

        return dp[a][b][c] = recur(a - 1, b, c) + recur(a - 1, b - 1, c) + recur(a - 1, b, c - 1) - recur(a - 1, b - 1, c - 1);
    }
}
