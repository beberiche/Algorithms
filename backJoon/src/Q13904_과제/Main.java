package Q13904_과제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, ans, arr[][], MAX;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            arr[i][0] = n1;
            arr[i][1] = n2;
            MAX = Math.max(arr[i][0], MAX);
        }

        Arrays.sort(arr, (n1, n2) -> n2[1] - n1[1]);
    }

    private static void solve() {
        int[] visited = new int[N];
        for (int i = MAX; i > 0; i--) {
            for (int j = 0; j < arr.length; j++) {
                if (visited[j] == 0 && arr[j][0] >= i) {
                    ans += arr[j][1];
                    visited[j]++;
                    break;
                }
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
