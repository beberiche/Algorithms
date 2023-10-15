package Q2239_스도쿠;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<int[]> list;
    static int map[][];

    private static void input() throws Exception {

        map = new int[9][9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = str.charAt(j) - '0';
                if (map[i][j] == 0) list.add(new int[]{i, j});
            }
        }
    }

    private static boolean check(int r, int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (map[r][i] == num || map[i][c] == num) return false;
        }

        int board_r = r / 3 * 3;
        int board_c = c / 3 * 3;

        for (int i = board_r; i < board_r + 3; i++) {
            for (int j = board_c; j < board_c + 3; j++) {
                if (map[i][j] == num) return false;
            }
        }

        return true;
    }

    private static void solve(int cnt) {
        if (list.size() <= cnt) {
            output();
        }


        for (int j = 1; j <= 9; j++) {
            int r = list.get(cnt)[0];
            int c = list.get(cnt)[1];

            if (check(r, c, j)) {
                map[r][c] = j;
                solve(cnt + 1);
                map[r][c] = 0;
            }
        }
    }

    private static void output() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        System.exit(0);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve(0);
    }
}
