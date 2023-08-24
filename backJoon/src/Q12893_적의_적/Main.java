package Q12893_적의_적;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, p[], e[];

    private static int find(int num) {
        if (p[num] == num) return num;
        return p[num] = find(p[num]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        p = new int[N + 1];
        e = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }


        boolean flag = false;
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            int x = find(n1);
            int y = find(n2);

            if (x == y) {
                flag = true;
                break;
            }

            if (e[n1] != 0) {
                int xx = find(e[n1]);
                int yy = find(n2);
                p[xx] = yy;
            } else {
                e[n1] = n2;
            }

            if (e[n2] != 0) {
                int xx = find(e[n2]);
                int yy = find(n1);
                p[xx] = yy;
            } else {
                e[n2] = n1;
            }
        }

        System.out.print((flag ? 0 : 1));
    }
}
