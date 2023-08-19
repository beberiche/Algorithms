package Q1365_꼬인_전깃줄;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[];
    static List<Integer> list;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
    }

    private static int lowerBound(int num) {
        int l = 0;
        int r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) >= num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private static void solve() {
        list = new ArrayList<>();
        list.add(arr[1]);
        for (int i = 2; i <= N; i++) {
            if (list.get(list.size() - 1) < arr[i]) {
                list.add(arr[i]);
            } else {
                int n = lowerBound(arr[i]);
                list.set(n, arr[i]);
            }
        }
    }

    private static void output() {
        System.out.print(N - list.size());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
