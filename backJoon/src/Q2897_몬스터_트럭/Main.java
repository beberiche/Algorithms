package Q2897_몬스터_트럭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] a;
    static int[][] dir = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(stk.nextToken());
        int C = Integer.parseInt(stk.nextToken());

        a = new char[R][C];
        for (int i = 0; i < R; i++) {
            a[i] = br.readLine().toCharArray();
        }

        int[] arr = new int[5];
        for (int i = 0; i < R - 1; i++) {
            for (int j = 0; j < C - 1; j++) {
                int cnt = getCount(i, j);
                if (cnt != -1) arr[cnt]++;
            }
        }

        for (int i : arr) {
            sb.append(i).append("\n");
        }

        System.out.print(sb);
    }

    private static int getCount(int y, int x) {
        int cnt = 0;
        for (int[] d : dir) {
            char c = a[y + d[0]][x + d[1]];
            if (c == 'X') cnt++;
            else if (c == '#') return -1;
        }

        return cnt;
    }
}
