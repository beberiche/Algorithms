package Q20955_민서의_응급_수술;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, p[];

    private static int find(int num) {
        if (num == p[num]) return num;
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

        int cnt = 0;
        int tmp = 1;
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            int x = find(n1);
            int y = find(n2);

            if (x != y) {
                p[y] = x;
                tmp++;
            } else {
                cnt++;
            }
        }

//        for (int i = 1; i < N; i++) {
//            int x = find(i);
//            int y = find(i + 1);
//
//            if (x != y) {
//                p[y] = x;
//                cnt++;
//            }
//        }
        if (tmp != N) {
            cnt += (N - tmp);
        }

        System.out.print(cnt);
    }
}
