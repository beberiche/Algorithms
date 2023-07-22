package Q19598_최소_회의실_개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 시작 시간 기준 정렬
// 이전 끝나는 시간 <= 다음 시작하는 시간 인 경우 회의실을 재사용할 수 있음.
public class Main {
    static int N, ans;
    static PriorityQueue<int[]> pq1;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        pq1 = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]);

        int n1, n2;
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(stk.nextToken());
            n2 = Integer.parseInt(stk.nextToken());
            pq1.add(new int[]{n1, n2});
        }
    }

    private static void solve() {
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        while (!pq1.isEmpty()) {
            int[] curr = pq1.poll();
            while (!pq2.isEmpty() && pq2.peek() <= curr[0]) pq2.poll();
            pq2.add(curr[1]);
            ans = Math.max(ans, pq2.size());
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
