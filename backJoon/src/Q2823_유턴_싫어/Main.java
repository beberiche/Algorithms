package Q2823_유턴_싫어;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        char[][] a = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                a[i][j] = str.charAt(j);
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] == 'X') {
                    continue;
                }
                int[] up = {i - 1, j};
                int[] down = {i + 1, j};
                int[] left = {i, j - 1};
                int[] right = {i, j + 1};

                int cnt = 0;
                if (up[0] >= 0 && a[up[0]][up[1]] == '.') {
                    cnt++;
                }
                if (down[0] < N && a[down[0]][down[1]] == '.') {
                    cnt++;
                }
                if (left[1] >= 0 && a[left[0]][left[1]] == '.') {
                    cnt++;
                }
                if (right[1] < M && a[right[0]][right[1]] == '.') {
                    cnt++;
                }

                if (cnt <= 1) {
                    ans = 1;
                    System.out.println(ans);
                    return;
                }
            }
        }
        System.out.println(ans);
    }
}
