package Q16202_MST_게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, arr[][], p[];
    static StringBuilder sb = new StringBuilder();

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        arr = new int[M][3];


        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(stk.nextToken());
            arr[i][1] = Integer.parseInt(stk.nextToken());
            arr[i][2] = i + 1;
        }
    }

    private static int find(int n) {
        if (p[n] == n) return n;
        return p[n] = find(p[n]);
    }

    private static void solve() {
        boolean flag = false;
        for (int i = 0; i < K; i++) {
            if (flag) {
//                System.out.println(0);
                sb.append(0).append(" ");
                continue;
            }
            p = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                p[j] = j;
            }

            int cnt = 0;
            int dist = 0;
            for (int j = i; j < M; j++) {
                int x = find(arr[j][0]);
                int y = find(arr[j][1]);

                if (x != y) {
                    if (x < y) {
                        p[y] = x;
                    } else if (x > y) {
                        p[x] = y;
                    }
                    cnt++;
                    dist += arr[j][2];
                }
            }
            if (cnt != N - 1) {
                flag = true;
                sb.append(0).append(" ");
            } else {
                sb.append(dist).append(" ");
            }
        }
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
