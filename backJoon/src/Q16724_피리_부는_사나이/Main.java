package Q16724_피리_부는_사나이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cnt, group[][];
    static char arr[][];
    static boolean finished[][], visited[][];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new char[N][M];

        String str;
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
    }

    private static void go(int i, int j) {
        visited[i][j] = true;

        int nr;
        int nc;
        if (arr[i][j] == 'U') {
            nr = i - 1;
            nc = j;
        } else if (arr[i][j] == 'D') {
            nr = i + 1;
            nc = j;
        } else if (arr[i][j] == 'L') {
            nr = i;
            nc = j - 1;
        } else {
            nr = i;
            nc = j + 1;
        }

        if (!visited[nr][nc]) {
            go(nr, nc);
        } else if (!finished[nr][nc]) {
            cnt++;
        }

        finished[i][j] = true;
    }

    private static void solve() {
        visited = new boolean[N][M];
        finished = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    go(i, j);
                }
            }
        }
    }

    private static void output() {
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
