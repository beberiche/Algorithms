package Q2571_색종이_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int arr[][], N, answer = -1;

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }

    private void output() {
        System.out.println(answer);
    }

    private void solve() {
        for (int i = 0; i < 99; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j] != 0 && arr[i + 1][j] != 0) {
                    arr[i + 1][j] = arr[i][j] + 1;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int h = 100;
                for (int k = j; k < 100; k++) {
                    h = Math.min(arr[i][k], h);
                    if (h == 0) break;
                    answer = Math.max(answer, h * (k - j + 1));
                }
            }
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[100][100];
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            for (int r = n1; r < n1 + 10; r++) {
                for (int c = n2; c < n2 + 10; c++) {
                    arr[r][c] = 1;
                }
            }
        }
    }
}
