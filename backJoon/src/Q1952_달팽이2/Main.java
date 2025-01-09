package Q1952_달팽이2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        boolean[][] a = new boolean[N][M];
        int d = 0;
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        // 오른쪽, 아래, 왼쪽, 위
        int r = 0;
        int c = 0;
        a[r][c] = true;
        int cnt = 0;
        for (int i = 0; i < N * M - 1; i++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M || a[nr][nc]) {
                d = (d + 1) % 4;
                cnt++;
                i--;
                continue;
            }
            a[nr][nc] = true;
            r = nr;
            c = nc;
        }
        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
    }
}
