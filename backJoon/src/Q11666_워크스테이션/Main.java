package Q11666_워크스테이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[][] a = new int[N][2];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(stk.nextToken());
            a[i][1] = Integer.parseInt(stk.nextToken());
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);

        Arrays.sort(a, (n1, n2) -> {
            if (n1[0] == n2[0]) return n1[1] - n2[1];
            return n1[0] - n2[0];
        });

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (pq.isEmpty() || a[i][0] < pq.peek()) {
                pq.add(a[i][0] + a[i][1]);
                continue;
            }

            int curr = pq.poll();
            if (a[i][0] <= curr + M) {
                cnt++;
                pq.add(a[i][0] + a[i][1]);
            } else {
                i--;
            }
        }

        System.out.println(cnt);
    }
}
