package Q2411_아이템_먹기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, A, B, arr[][], dp[][];
    static List<int[]> list;
    static int dr[] = {1, 0};
    static int dc[] = {0, 1};

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        A = Integer.parseInt(stk.nextToken());
        B = Integer.parseInt(stk.nextToken());

        arr = new int[N + 1][M + 1];
        list = new ArrayList<>();
        list.add(new int[]{1, 1});
        for (int i = 0; i < A; i++) {
            stk = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            list.add(new int[]{r, c});
        }
        list.add(new int[]{N, M});

        Collections.sort(list, (n1, n2) -> {
            if (n1[0] == n2[0]) return n1[1] - n2[1];
            return n1[0] - n2[0];
        });

        for (int i = 0; i < B; i++) {
            stk = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            arr[r][c] = 1;
        }
    }

    private static void solve() {
        dp = new int[N + 1][M + 1];
        dp[0][1] = 1;
        for (int i = 1; i < list.size(); i++) {
            int[] st = list.get(i - 1);
            int[] ed = list.get(i);

            for (int r = st[0]; r <= ed[0]; r++) {
                for (int c = st[1]; c <= ed[1]; c++) {
                    if (arr[r][c] > 0) continue;
                    dp[r][c] = (arr[r - 1][c] != 2 ? dp[r - 1][c] : 0) + (arr[r][c - 1] != 2 ? dp[r][c - 1] : 0);
                }
            }
        }
    }

    private static void output() {
        System.out.println(dp[N][M]);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
