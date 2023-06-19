package Q14938_서강그라운드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R, a[][], t[], INF = 987654321, ans;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());

        a = new int[N + 1][N + 1];
        t = new int[N + 1];
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            t[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                a[i][j] = INF;
            }
        }

        for (int i = 0; i < R; i++) {
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int ed = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());
            if(dist <= M) {
                a[st][ed] = dist;
                a[ed][st] = dist;
            }
        }
    }


    private static void solve() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (a[i][j] > (a[i][k] + a[k][j]) && (a[i][k] + a[k][j]) <= M) {
                        a[i][j] = a[i][k] + a[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int ret = t[i];
            for (int j = 1; j <= N; j++) {
                if (a[i][j] <= M) ret += t[j];
            }
            ans = Math.max(ret, ans);
        }
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
