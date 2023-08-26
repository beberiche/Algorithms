package Q1477_휴게소_세우기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, L, arr[], l, r, ans;
    static List<Integer> list;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        L = Integer.parseInt(stk.nextToken());

        arr = new int[N + 2];
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        arr[N + 1] = L;

        Arrays.sort(arr);

        list = new ArrayList<>();
        int prev = arr[0];

        for (int i = 1; i <= N + 1; i++) {
            int num = arr[i] - prev;
            list.add(num);
            r = Math.max(r, num);
            prev = arr[i];
        }
    }

    private static int go(int mid) {
        int cnt = 0;
        for (int n : list) {
            cnt += n / mid;
            if (n % mid == 0) cnt--;
        }
        return cnt;
    }

    private static void solve() {
        while (l < r) {
            int mid = (l + r) / 2;
            if (mid !=0 && go(mid) <= M) {
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
