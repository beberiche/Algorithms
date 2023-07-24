package Q3109_빵집;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DFS
// 최대한 일직선 형태로 나가도록 해야 최대 갯수가 나온다.
// 임의의 값에서 가장 위에 먼저 봐주고, 그다음 오른쪽 봐주고, 그다음 오른쪽 아래 봐주고
// 방문처리 되어있거나, 건물이 있다면 못감
// 끝까지 도달한 경우 ans++
public class Main {
    static int R, C, ans, visited[][], cnt = 1;
    static char a[][];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        a = new char[R][C];
        visited = new int[R][C];
        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                a[i][j] = tmp.charAt(j);
            }
        }
    }

    private static boolean check(int r, int c) {
        return r < 0 || c < 0 || r >= R || c >= C || visited[r][c] > 0 || a[r][c] == 'x';
    }

    private static boolean solve(int r, int c) {
        if (c == C - 1) {
            ans++;
            return true;
        }

        boolean flag = false;
        if (!check(r - 1, c + 1)) {
            visited[r - 1][c + 1] = cnt;
            flag = solve(r - 1, c + 1);
        }
        if (!flag && !check(r, c + 1)) {
            visited[r][c + 1] = cnt;
            flag = solve(r, c + 1);
        }
        if (!flag && !check(r + 1, c + 1)) {
            visited[r + 1][c + 1] = cnt;
            flag = solve(r + 1, c + 1);
        }
        return flag;
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        for (int r = 0; r < R; r++) {
            visited[r][0] = cnt;
            solve(r, 0);
            cnt++;
        }
        output();
    }
}
