package Q2953_나는_요리사다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 5;
        int wIdx = 0;
        int wScore = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int score = 0;
            for (int j = 0; j < 4; j++) {
                score += Integer.parseInt(stk.nextToken());
            }
            if (wScore < score) {
                wScore = score;
                wIdx = i;
            }
        }
        System.out.println(wIdx + " " + wScore);
    }
}
