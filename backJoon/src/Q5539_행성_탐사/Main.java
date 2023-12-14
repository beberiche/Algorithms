package Q5539_행성_탐사;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int[][] J, I, O;
    int M, N, K;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stk;
    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }

    private void output() {
        System.out.print(sb.toString());
    }

    private void solve() throws Exception{
        for(int i=0; i<K; i++) {
            stk = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            int n3 = Integer.parseInt(stk.nextToken());
            int n4 = Integer.parseInt(stk.nextToken());

            int jj = J[n3][n4] - J[n3][n2-1] - J[n1-1][n4] + J[n1-1][n2-1];
            int oo = O[n3][n4] - O[n3][n2-1] - O[n1-1][n4] + O[n1-1][n2-1];
            int ii = I[n3][n4] - I[n3][n2-1] - I[n1-1][n4] + I[n1-1][n2-1];

            sb.append(jj).append(" ").append(oo).append(" ").append(ii).append("\n");
        }
    }

    private void input() throws Exception {
        stk = new StringTokenizer(br.readLine());

        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(br.readLine());

        J = new int[M + 1][N + 1];
        I = new int[M + 1][N + 1];
        O = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                char ch = str.charAt(j-1);
                int jj = ch == 'J' ? 1 : 0;
                int ii = ch == 'I' ? 1 : 0;
                int oo = ch == 'O' ? 1 : 0;

                J[i][j] = J[i-1][j] + J[i][j-1] - J[i-1][j-1] + jj;
                I[i][j] = I[i-1][j] + I[i][j-1] - I[i-1][j-1] + ii;
                O[i][j] = O[i-1][j] + O[i][j-1] - O[i-1][j-1] + oo;
            }
        }
    }
}
