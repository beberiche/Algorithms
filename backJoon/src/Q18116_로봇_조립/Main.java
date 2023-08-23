package Q18116_로봇_조립;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, p[], cnt[], MAX = 1000000 + 4;
    static StringBuilder sb = new StringBuilder();

    private static int find(int n) {
        if (p[n] == n) return n;
        return p[n] = find(p[n]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        p = new int[MAX];
        cnt = new int[MAX];
        for (int i = 1; i < MAX; i++) {
            p[i] = i;
            cnt[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            char cmd = stk.nextToken().charAt(0);

            if (cmd == 'I') {
                int n1 = Integer.parseInt(stk.nextToken());
                int n2 = Integer.parseInt(stk.nextToken());
                if (n1 > n2) {
                    int tmp = n1;
                    n1 = n2;
                    n2 = tmp;
                }
                int x = find(n1);
                int y = find(n2);

                if (x != y) {
                    p[y] = x;
                    cnt[x] += cnt[y];
                }
            } else {
                int num = Integer.parseInt(stk.nextToken());
                int x = find(num);
                //System.out.println(cnt[x]);
                sb.append(cnt[x]).append("\n");
            }
        }
        System.out.print(sb.toString());

    }
}
