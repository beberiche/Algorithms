package Q16168_퍼레이드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int V, E, p[], cnt[];

    private static int find(int num) {
        if (p[num] == num) return num;
        return p[num] = find(p[num]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        V = Integer.parseInt(stk.nextToken());
        E = Integer.parseInt(stk.nextToken());

        p = new int[V + 1];
        cnt = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            p[i] = i;
        }

        for (int i = 0; i < E; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            cnt[n1]++;
            cnt[n2]++;

            int x = find(n1);
            int y = find(n2);

            if (x < y) {
                p[y] = x;
            } else {
                p[x] = y;
            }
        }

        int cnt2 = 0;
        boolean check = false;
        int prev = find(1);
        for (int i = 1; i <= V; i++) {
            if (prev != find(i)) {
                check = true;
                break;
            }
            if (cnt[i] % 2 == 1) cnt2++;
        }

        System.out.println(((check || cnt2 == 1 || cnt2 > 2) ? "NO" : "YES"));
    }
}
