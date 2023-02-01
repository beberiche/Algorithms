package Q2630_색종이_만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N;
    static int white, blue;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
    }

    private static void solve(int r1, int r2, int c1, int c2) {
        if (r1 == N-1 || c1 == N-1 || r2 == 0 || c2 == 0) {
            count(map[r1][c1]);
            return;
        }

        int num = map[r1][c1];
        boolean check = true;
        outer:
        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                if (num != map[r][c]) {
                    check = false;
                    break outer;
                }
            }
        }

        if(check) {
            count(num);
            return;
        }

        solve(r1, (r1+r2)/2, (c1+c2)/2+1, c2);
        solve(r1, (r1+r2)/2, c1, (c1+c2)/2);
        solve((r1+r2)/2+1, r2, c1, (c1+c2)/2);
        solve((r1+r2)/2+1, r2, (c1+c2)/2+1, c2);
    }

    private static void count(int num) {
        int tmp = num == 1 ? blue++ : white++;
    }

    public static void main(String[] args) throws Exception {
        input();
        solve(0, N-1, 0, N-1);
        System.out.print(white+ "\n" + blue);
    }
}
