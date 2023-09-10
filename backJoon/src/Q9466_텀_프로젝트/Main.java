package Q9466_텀_프로젝트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, arr[], visited[], team, idx;
    static boolean finished[];
    static StringBuilder sb = new StringBuilder();

    private static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new int[N + 1];
        finished = new boolean[N + 1];
        team = 0;
        idx = 0;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
    }

    private static void go(int curr) {
        if (finished[arr[curr]]) return;
        visited[curr] = idx++;

        if (visited[arr[curr]] == 0) go(arr[curr]);
        else team += visited[curr] - visited[arr[curr]] + 1;

        finished[curr] = true;
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            if (!finished[i]) go(i);
        }
        sb.append(N - team).append("\n");
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            input();
            solve();
        }
        output();
    }
}
