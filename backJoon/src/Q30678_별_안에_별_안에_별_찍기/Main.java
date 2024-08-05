package Q30678_별_안에_별_안에_별_찍기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int N, a[][];
    private static char[][] ret;
    private static void go(int r, int c, int d) {
        if (d == 1) {
            ret[r][c] = '*';
            return;
        }

        int nd = d / 5;
        for (int[] p : a) {
            int nr = r + p[0] * nd;
            int nc = c + p[1] * nd;
            go(nr, nc, nd);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = (int) Math.pow(5, Integer.parseInt(br.readLine()));

        a = new int[][]{{0, 2}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {3, 1}, {3, 2}, {3, 3}, {4, 1}, {4, 3}};
        ret = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(ret[i], ' ');
        }
        go(0, 0, N);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(ret[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
