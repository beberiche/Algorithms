package Q1744_수_묶기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 양수, 음수 정렬, 0도 음수로 (음수에 0을 곱하게 하면 어떤 음수값보다 클 터이니)
// 음수는 음수끼리 *
// 양수는 두 합 가운데 1이 있다면 +
//      그게 아니라면 *
public class Main {
    static int ans;
    static PriorityQueue<Integer> pq1, pq2;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num;
        pq1 = new PriorityQueue<>();
        pq2 = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            if (num <= 0) pq1.add(num);
            else pq2.add(num);
        }
    }

    private static void solve() {
        int len = pq1.size() / 2;
        while (--len >= 0) ans += pq1.poll() * pq1.poll();
        if (!pq1.isEmpty()) ans += pq1.poll();


        len = pq2.size() / 2;
        while (--len >= 0) {
            int n1 = pq2.poll();
            int n2 = pq2.poll();
            if (n1 == 1 || n2 == 1) ans += n1 + n2;
            else ans += n1 * n2;
        }
        if (!pq2.isEmpty()) ans += pq2.poll();
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
