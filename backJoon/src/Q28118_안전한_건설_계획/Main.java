package Q28118_안전한_건설_계획;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }


        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            int x = find(a);
            int y = find(b);

            if (x != y) {
                union(x, y);
            }
        }

        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            int x = find(i - 1);
            int y = find(i);

            if (x != y) {
                cnt++;
                union(x, y);
            }
        }
        System.out.print(cnt);
    }

    private static int find(int num) {
        if (num == p[num]) return num;
        return p[num] = find(p[num]);
    }

    private static void union(int x, int y) {
        if (x < y) {
            p[y] = x;
        }

        if (y < x) {
            p[x] = y;
        }
    }
}
