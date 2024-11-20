package Q1267_핸드폰_요금;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int y = 0;
        int m = 0;
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(stk.nextToken());
            y += calY(val);
            m += calM(val);
        }
        if (y == m) {
            System.out.printf("%s %s %d", "Y", "M", m);
        } else if (y < m) {
            System.out.printf("%s %d", "Y", y);
        } else {
            System.out.printf("%s %d", "M", m);
        }
    }

    private static int calY(int val) {
        return (val / 30 + 1) * 10;
    }

    private static int calM(int val) {
        return (val / 60 + 1) * 15;
    }
}
