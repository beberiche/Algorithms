package Q1374_강의실;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, ans;
    static List<int[]> list;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            stk.nextToken();
            list.add(new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())});
        }

        Collections.sort(list, (n1, n2) -> n1[0] - n2[0]);
    }

    private static void solve() {
        for (int i = 0; i < list.size(); i++) {
            if (!pq.isEmpty() && pq.peek() <= list.get(i)[0]) {
                pq.poll();
            } else ans++;
            pq.add(list.get(i)[1]);
        }
    }


    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
