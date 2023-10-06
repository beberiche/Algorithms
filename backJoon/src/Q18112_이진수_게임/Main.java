package Q18112_이진수_게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int L, K, ans;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                L += 1 << str.length() - i - 1;
            }
        }
        str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                K += 1 << str.length() - i - 1;
            }
        }
    }


    private static void solve() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{L, 0});

        boolean[] visited = new boolean[1024];
        visited[L] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == K) {
                ans = curr[1];
                break;
            }


            int idx = 0;
            while (true) {
                int num = 1 << idx;
                int cmp = 1 << (idx++ + 1);
                if (cmp > curr[0]) break;

                int next = curr[0] ^ num;
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{curr[0] ^ num, curr[1] + 1});
                }
            }


            if (curr[0] - 1 >= 0 && !visited[curr[0] - 1]) {
                visited[curr[0] - 1] = true;
                q.add(new int[]{curr[0] - 1, curr[1] + 1});
            }

            if (curr[0] + 1 < 1024 && !visited[curr[0] + 1]) {
                visited[curr[0] + 1] = true;
                q.add(new int[]{curr[0] + 1, curr[1] + 1});
            }
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

