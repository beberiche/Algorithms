package Q15789_CTP_왕국은_한솔_왕국을_이길_수_있을까;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, p[], cnt[][], C, H, K, ans;


    private static int find(int num) {
        if (p[num] == num) return num;
        return p[num] = find(p[num]);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        p = new int[N + 1];
        cnt = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            p[i] = i;
            cnt[i][0] = i;
            cnt[i][1] = 1;
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            int x = find(n1);
            int y = find(n2);

            if (x != y) {
                if (x < y) {
                    p[y] = x;
                    cnt[x][1] += cnt[y][1];
                } else {
                    p[x] = y;
                    cnt[y][1] += cnt[x][1];
                }
            }
        }

        stk = new StringTokenizer(br.readLine());

        C = Integer.parseInt(stk.nextToken());
        H = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
    }

    private static void solve() {

        int n = find(C);
        int cc = cnt[n][0];
        ans = cnt[n][1];
        int hh = cnt[find(H)][0];

        Arrays.sort(cnt, (n1, n2) -> n2[1] - n1[1]);
        boolean visited[] = new boolean[N + 1];
        visited[cc] = true;
        visited[hh] = true;
        for (int i = 0; i <= N; i++) {
            if (K == 0) break;
            int f = find(cnt[i][0]);
            if (!visited[f]) {
                ans += cnt[i][1];
                visited[f] = true;
                K--;
            }
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
