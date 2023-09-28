package Q2585_경비행기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, arr[][];
    static int l, r;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        arr = new int[N + 2][2];

        arr[0] = new int[]{0, 0};
        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            arr[i][0] = n1;
            arr[i][1] = n2;
        }
        arr[N + 1] = new int[]{10000, 10000};
    }

    private static boolean go(int mid) {
        boolean visited[] = new boolean[N + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (oil(curr[0], N + 1) <= mid) {
                return true;
            }

            if (curr[1] >= K) continue;
            for (int i = 1; i <= N; i++) {
                if (visited[i] || oil(curr[0], i) > mid)
                    continue;

                visited[i] = true;
                q.add(new int[]{i, curr[1] + 1});
            }
        }
        return false;
    }

    private static int oil(int idx, int idx2) {
        int ans = (int) Math.ceil(Math.sqrt(Math.pow(arr[idx][0] - arr[idx2][0], 2) + Math.pow(arr[idx][1] - arr[idx2][1], 2)));
        return ans % 10 == 0 ? ans / 10 : ans / 10 + 1;
    }

    private static void solve() {
        l = 0;
        r = oil(0, N + 1) + 1;
        int ans = 987654321;
        while (l < r) {
            int mid = (l + r) / 2;
            if (go(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
    }

    private static void output() {
        System.out.println(r);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}



