package Q3151_합이_0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, Long> m = new HashMap<>();
    static int N, arr[];
    static long ans;
    static List<Integer> list;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
    }

    private static int go(int num, int start, boolean check) {
        int l = start;
        int r = N;
        while (l < r) {
            int mid = (l + r) / 2;
            if (check ? arr[mid] >= num : arr[mid] > num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private static void solve() {
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int sum = arr[i] + arr[j];

                int lower = go(-sum, j + 1, true);
                int upper = go(-sum, j + 1, false);
                ans += upper - lower;
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
