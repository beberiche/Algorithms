package Q9339_마라토너;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(stk.nextToken());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] students = new int[N];
            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                students[i] = Integer.parseInt(stk.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int bestScore = 987654321;
            int successCnt = 0;
            int bestScoreIdx = 0;

            for (int i = 0; i < M; i++) {
                stk = new StringTokenizer(br.readLine());
                int number = Integer.parseInt(stk.nextToken());
                int hour = Integer.parseInt(stk.nextToken());
                int min = Integer.parseInt(stk.nextToken());

                for (int j = 0; j < N; j++) {
                    if (students[j] == number) {
                        int score = hour * 60 + min;
                        if (score >= 0 && score <= 6 * 60) {
                            if (score < bestScore) {
                                bestScore = score;
                                bestScoreIdx = j;
                            }
                            successCnt++;
                        }
                        break;
                    }
                }
            }
            sb.append(students[bestScoreIdx]).append(' ').append(successCnt).append('\n');
        }
        System.out.print(sb.toString());
    }
}

