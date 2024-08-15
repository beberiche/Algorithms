package Q20757_Roadside_optimization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int p[], a[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (--T >= 0) {
            int N = Integer.parseInt(br.readLine());
            p = new int[N + 1];
            a = new int[N + 1][N + 1];
            int ret = 0;
            for (int i = 1; i <= N; i++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                p[i] = i;
                for (int j = 1; j <= N; j++) {
                    int num = Integer.parseInt(stk.nextToken());
                    if (num == 1 && i != j) ret++;
                    a[i][j] = num;
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    if (a[i][j] == 1) {
                        int n1 = find(i);
                        int n2 = find(j);
                        if (n1 == n2) {
                            ret -= 2;
                        } else {
                            ret--;
                            p[n2] = n1;
                        }
                    }
                }
            }
            sb.append(ret).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int find(int x) {
        if (p[x] == x) return x;
        return p[x] = find(p[x]);
    }
}
