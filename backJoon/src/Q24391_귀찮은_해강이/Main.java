package Q24391_귀찮은_해강이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, p[];

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

        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            int x = find(n1);
            int y = find(n2);

            if (x < y) p[y] = x;
            else p[x] = y;
        }

        stk = new StringTokenizer(br.readLine());
        int prev = find(Integer.parseInt(stk.nextToken()));
        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            int num = find(Integer.parseInt(stk.nextToken()));
            if (prev != num) cnt++;
            prev = num;
        }
        System.out.println(cnt);
        br.close();
    }
}
