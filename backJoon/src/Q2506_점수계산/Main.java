package Q2506_점수계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int total = 0;
        int score = 0;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int q = Integer.parseInt(stk.nextToken());
            if (q == 1) {
                score++;
                total += score;
            } else {
                score = 0;
            }
        }
        System.out.print(total);
    }
}