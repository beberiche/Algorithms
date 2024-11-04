package Q1173_운동;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int T = Integer.parseInt(stk.nextToken());
        int R = Integer.parseInt(stk.nextToken());

        int res = 0;
        int cnt = 0;
        int init = m;

        while (cnt != N) {
            res++;
            if (m + T <= M) {
                m += T;
                cnt++;
            } else {
                m = Math.max(m - R, init);
            }

            if (m + T > M && m == init) break;
        }

        System.out.println(cnt != N ? -1 : res);
    }
}
