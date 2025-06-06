package Q4493_가위_바위_보;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int A_wins = 0, B_wins = 0;

            for (int j = 0; j < N; j++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                String A_move = stk.nextToken();
                String B_move = stk.nextToken();

                if (A_move.equals(B_move)) {
                    continue; // 무승부는 아무도 이기지 않음
                } else if ((A_move.equals("S") && B_move.equals("P")) ||
                        (A_move.equals("R") && B_move.equals("S")) ||
                        (A_move.equals("P") && B_move.equals("R"))) {
                    A_wins++;
                } else {
                    B_wins++;
                }
            }

            if (A_wins > B_wins) {
                result.append("Player 1\n");
            } else if (B_wins > A_wins) {
                result.append("Player 2\n");
            } else {
                result.append("TIE\n");
            }
        }

        System.out.print(result.toString());
        br.close();
    }
}
