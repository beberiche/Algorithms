package Q2930_가위_바위_보;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        char[] a = stk.nextToken().toCharArray();

        N = Integer.parseInt(br.readLine());
        char[][] b = new char[N][R];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            b[i] = stk.nextToken().toCharArray();
        }

        int score = 0;
        for (int j = 0; j < R; j++) {
            for (int i = 0; i < N; i++) {
                score += getScore(a[j], b[i][j]);
            }
        }

        int bestScore = 0;
        for (int j = 0; j < R; j++) {
            int rScore = 0;
            int sScore = 0;
            int pScore = 0;
            for (int i = 0; i < N; i++) {
                rScore += getScore('R', b[i][j]);
                sScore += getScore('S', b[i][j]);
                pScore += getScore('P', b[i][j]);
            }
            bestScore += Math.max(rScore, Math.max(sScore, pScore));
        }

        System.out.println(score);
        System.out.println(bestScore);
    }

    public static int getScore(char ch, char f) {
        if (ch == f)
            return 1;
        switch (ch) {
            case 'R':
                return f == 'S' ? 2 : 0;
            case 'S':
                return f == 'P' ? 2 : 0;
            case 'P':
                return f == 'R' ? 2 : 0;
            default:
                return 0;
        }
    }
}
