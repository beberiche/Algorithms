package Q2246_콘도_선정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] a = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(stk.nextToken());
            a[i][1] = Integer.parseInt(stk.nextToken());
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (check(a, i)) cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean check(int[][] a, int idx) {
        for (int i = 0; i < a.length; i++) {
            if (i == idx) continue;
            if (a[idx][0] >= a[i][0] && a[idx][1] >= a[i][1]) return false;
        }

        return true;
    }
}
