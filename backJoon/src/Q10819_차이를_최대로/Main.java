package Q10819_차이를_최대로;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int a[], N;
    private static int ans = -999999;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }

        visited = new boolean[N];
        int[] tmp = new int[N];
        Arrays.fill(tmp, -1);
        go(0, tmp);
        System.out.println(ans);
    }

    private static void go(int idx, int[] tmp) {
        if (idx >= N) {
            int sum = 0;
            for (int i = 1; i < N; i++) {
                sum += Math.abs(a[tmp[i - 1]] - a[tmp[i]]);
            }
            ans = Math.max(sum, ans);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp[idx] = i;
                go(idx + 1, tmp);
                visited[i] = false;
            }
        }
    }
}
