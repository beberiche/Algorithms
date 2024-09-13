package Q12759_틱택토;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] g = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                g[i][j] = ' ';
            }
        }


        int player = Integer.parseInt(br.readLine());
        int winner = 0;

        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken()) - 1;
            int y = Integer.parseInt(stk.nextToken()) - 1;

            if (player == 1) g[x][y] = 'O';
            else g[x][y] = 'X';

            char[][] res = new char[8][3];
            int idx = 0;

            for (int i = 0; i < 3; i++) {
                res[idx][0] = g[i][0];
                res[idx][1] = g[i][1];
                res[idx][2] = g[i][2];
                idx++;
            }

            for (int i = 0; i < 3; i++) {
                res[idx][0] = g[0][i];
                res[idx][1] = g[1][i];
                res[idx][2] = g[2][i];
                idx++;
            }

            res[idx][0] = g[0][0];
            res[idx][1] = g[1][1];
            res[idx][2] = g[2][2];
            idx++;

            res[idx][0] = g[0][2];
            res[idx][1] = g[1][1];
            res[idx][2] = g[2][0];

            for (int i = 0; i < 8; i++) {
                if (res[i][0] == 'O' && res[i][1] == 'O' && res[i][2] == 'O') winner = 1;
                if (res[i][0] == 'X' && res[i][1] == 'X' && res[i][2] == 'X') winner = 2;
            }

            if (winner == 0) {
                boolean flag = false;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (res[i][j] == ' ') {
                            flag = true;
                            break;
                        }
                    }
                }
                if (!flag) winner = 3;
            }

            if (winner > 0) break;

            if (player == 1) player = 2;
            else player = 1;
        }

        if (winner < 3) System.out.println(winner);
        else System.out.println(0);
    }
}
