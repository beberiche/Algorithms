package Q2493_탑;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[];
    static Stack<int[]> s1, s2;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        s1 = new Stack<>();
        s2 = new Stack<>();
        for (int i = 1; i <= N; i++) {
            s1.add(new int[]{i, Integer.parseInt(stk.nextToken())});
        }
    }

    private static void solve() {
        arr = new int[N + 1];
        int[] num = s1.pop();
        while (!s1.isEmpty()) {
            int[] curr = s1.pop();
            if (curr[1] > num[1]) {
                arr[num[0]] = curr[0];
                while (!s2.isEmpty() && s2.peek()[1] < curr[1]) {
                    arr[s2.pop()[0]] = curr[0];
                }
            } else {
                s2.add(num);
            }
            num = curr;
        }
    }

    private static void output() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
