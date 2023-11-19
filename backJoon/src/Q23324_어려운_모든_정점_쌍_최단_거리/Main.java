package Q23324_어려운_모든_정점_쌍_최단_거리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int N, M, K, p[], A, B, cnt1, cnt2;

    private int find(int num) {
        if (p[num] == num) return num;
        return p[num] = find(p[num]);
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

//        list = new ArrayList[N + 1];
        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            stk = new StringTokenizer(br.readLine());

            int n1 = find(Integer.parseInt(stk.nextToken()));
            int n2 = find(Integer.parseInt(stk.nextToken()));

            if (K == i) {
                A = n1;
                B = n2;
                continue;
            }

            if (n1 < n2) {
                p[n2] = n1;
            } else if (n1 > n2) {
                p[n1] = n2;
            }
        }
    }


    private void solve() {
        int p1 = find(A);
        int p2 = find(B);
        for (int i = 1; i <= N; i++) {
            int num = find(i);
            if (num == p1) cnt1++;
            else if (num == p2) cnt2++;
        }
    }

    private void output() {
        System.out.println(1l * cnt1 * cnt2);
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }
}
