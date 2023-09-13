package Q20444_색종이와_가위;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이 총 갯수 (r방항으로 자른 수+1)*(c방향으로 자른 수+1)
// 색종이는 r,c 간의 오차가 적을수록 커진다.
// r,c의 오차범위를 기반으로 이분탐색
public class Main {
    static long N, K;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Long.parseLong(stk.nextToken());
        K = Long.parseLong(stk.nextToken());
    }

    private static String solve() {
        long l = 0;
        long r = N / 2;

        while (l <= r) {
            long row = (l + r) / 2;
            long num = (row + 1) * ((N - row) + 1);

            if (num == K) return "YES";
            else if (num < K) {
                l = row + 1;
            } else {
                r = row - 1;
            }
        }

        return "NO";
    }

    public static void main(String[] args) throws Exception {
        input();
        System.out.print(solve());
    }
}
