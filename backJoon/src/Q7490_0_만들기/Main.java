package Q7490_0_만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (--T >= 0) {
            N = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            go(1, "1");
            System.out.println(sb.toString());
        }
    }

    private static void go(int num, String exp) {
        if (num >= N) {
            String str = exp.replaceAll(" ", "");
            if (check(str)) {
                sb.append(exp).append("\n");
            }
            return;
        }

        int next = num + 1;

        go(next, exp + " " + next); // 20
        go(next, exp + "+" + next); // 43
        go(next, exp + "-" + next); // 45
    }

    private static boolean check(String str) {
        StringTokenizer stk = new StringTokenizer(str, "-|+", true);

        int sum = Integer.parseInt(stk.nextToken());

        while (stk.hasMoreElements()) {
            String curr = stk.nextToken();
            if (curr.equals("+")) {
                sum += Integer.parseInt(stk.nextToken());
            } else if (curr.equals("-")) {
                sum -= Integer.parseInt(stk.nextToken());
            }
        }

        return sum == 0;
    }
}
