package Q9465_스티커;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int arr[][], N;

    private static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[2][N + 2];
        for (int i = 0; i < 2; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 2; j < N + 2; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
    }

    private static void solve() {
        for (int i = 2; i < N + 2; i++) {
            for (int j = 0; j < 2; j++) {
                int tmp = j == 0 ? 1 : 0;
                arr[j][i] += Math.max(arr[tmp][i - 2], arr[tmp][i - 1]);
            }
        }
        sb.append(Math.max(arr[0][N + 1], arr[1][N + 1])).append("\n");
    }


    private static void output() {
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            input();
            solve();
        }
        output();
    }
}
