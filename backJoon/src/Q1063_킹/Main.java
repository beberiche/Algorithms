package Q1063_킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int k[], s[], len;
    private static Map<Integer, Character> m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        k = changeStringToPos(stk.nextToken());
        s = changeStringToPos(stk.nextToken());
        len = 8;
        int N = Integer.parseInt(stk.nextToken());
        m = new HashMap<>();
        char key = 'A';
        for (int i = 0; i < len; i++) {
            m.put(i, key++);
        }

        for (int i = 0; i < N; i++) {
            go(br.readLine());
        }

        System.out.println(changePosToString(k));
        System.out.println(changePosToString(s));
    }

    private static void go(String cmd) {
        if (cmd.equals("R")) {
            goProcess(new int[]{k[0], k[1] + 1}, new int[]{s[0], s[1] + 1});
        } else if (cmd.equals("L")) {
            goProcess(new int[]{k[0], k[1] - 1}, new int[]{s[0], s[1] - 1});
        } else if (cmd.equals("B")) {
            goProcess(new int[]{k[0] - 1, k[1]}, new int[]{s[0] - 1, s[1]});
        } else if (cmd.equals("T")) {
            goProcess(new int[]{k[0] + 1, k[1]}, new int[]{s[0] + 1, s[1]});
        } else if (cmd.equals("RT")) {
            goProcess(new int[]{k[0] + 1, k[1] + 1}, new int[]{s[0] + 1, s[1] + 1});
        } else if (cmd.equals("LT")) {
            goProcess(new int[]{k[0] + 1, k[1] - 1}, new int[]{s[0] + 1, s[1] - 1});
        } else if (cmd.equals("RB")) {
            goProcess(new int[]{k[0] - 1, k[1] + 1}, new int[]{s[0] - 1, s[1] + 1});
        } else if (cmd.equals("LB")) {
            goProcess(new int[]{k[0] - 1, k[1] - 1}, new int[]{s[0] - 1, s[1] - 1});
        }
    }

    private static void goProcess(int[] nextK, int[] nextS) {
        if (!outOfPos(nextK)) {
            if (checkEqualPos(nextK, s)) {
                if (!outOfPos(nextS)) {
                    k = nextK;
                    s = nextS;
                }
            } else {
                k = nextK;
            }
        }
    }

    private static boolean checkEqualPos(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    private static boolean outOfPos(int[] pos) {
        return pos[0] < 0 || pos[1] < 0 || pos[0] >= len || pos[1] >= len;
    }

    private static int[] changeStringToPos(String s) {
        int col = s.charAt(0) - 'A';
        int row = (int) (s.charAt(1) - '0') - 1;
        return new int[]{row, col};
    }

    private static String changePosToString(int[] pos) {
        return "" + m.get(pos[1]) + (pos[0] + 1);
    }
}
