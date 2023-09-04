package Q15347_양_구출_작전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, arr[];
    static long ans;
    static List<Integer> list[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        list = new ArrayList[N + 1];
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 2; i <= N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            char type = stk.nextToken().charAt(0);
            int cnt = Integer.parseInt(stk.nextToken());
            int next = Integer.parseInt(stk.nextToken());

            arr[i] = type == 'W' ? -cnt : cnt;
            list[next].add(i);
        }
    }


    private static long solve(int idx) {
        long ans = 0;
        ans += arr[idx];
        for (int n : list[idx]) {
            ans += solve(n);
        }
        return ans < 0 ? 0 : ans;
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        ans = solve(1);
        output();
    }
}
