package Q16168_퍼레이드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int p[], cnt[], N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        p = new int[N + 1];
        cnt = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }


        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            cnt[n1]++;
            cnt[n2]++;

            int x = find(n1);
            int y = find(n2);
            union(x,y);
        }
        int node = find(1);
        int ans = 0;
        boolean check = false;
        for (int i = 1; i <= N; i++) {
            if (node != find(i)) {
                check = true;
                break;
            }
            if (cnt[i] % 2 == 1) {
                ans++;
            }
        }

        String ret = "NO";
        if (!check && (ans == 0 || ans == 2)) {
            ret = "YES";
        }
        System.out.println(ret);
    }

    private static int find(int n) {
        if (p[n] == n) return n;
        return p[n] = find(p[n]);
    }

    private static void union(int x, int y) {
        if (x < y) p[y] = x;
        else p[x] = y;
    }
}
