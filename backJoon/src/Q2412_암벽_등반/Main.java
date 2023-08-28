package Q2412_암벽_등반;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, T, ans;
    static List<int[]> list;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        T = Integer.parseInt(stk.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            list.add(new int[]{x, y});
        }

        Collections.sort(list, (n1, n2) -> {
            if (n1[0] == n2[0]) return n1[1] - n2[1];
            return n1[0] - n2[0];
        });
    }

    private static int binarySearch(int num) {
        int l = 0;
        int r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (num <= list.get(mid)[0]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private static void solve() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        int[] visited = new int[N];

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[1] == T) {
                ans = curr[2];
                break;
            }
            int lower = binarySearch(curr[0]-2);
            for (int i = lower; i < N; i++) {
                if (Math.abs(curr[0] - list.get(i)[0]) > 2) break;
                if (Math.abs(curr[1] - list.get(i)[1]) <= 2 && visited[i] == 0) {
                    visited[i]++;
                    q.add(new int[]{list.get(i)[0], list.get(i)[1], curr[2] + 1});
                }
            }
        }
    }

    private static void output() {
        System.out.println((ans == 0 ? -1 : ans));
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
