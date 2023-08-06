package Q11054_가장_긴_바이토닉_부분_수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int arr[], ans, dp1[], dp2[];
    static List<Integer> list, list2;

    private static int lowerBound(int i, List<Integer> currList) {
        int l = 0;
        int r = currList.size();
        int idx = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (currList.get(mid) >= arr[i]) {
                idx = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return idx;
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;

    private static void input() throws Exception {
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        list = new LinkedList<>();
        list2 = new LinkedList<>();
    }

    private static void solve() throws Exception {
        stk = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(stk.nextToken());
        list.add(arr[0]);
        dp1 = new int[arr.length];
        dp1[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            if (list.get(list.size() - 1) < arr[i]) {
                list.add(arr[i]);
                dp1[i] = list.size();
            }
            else {
                int ret = lowerBound(i, list);
                list.set(ret, arr[i]);
                dp1[i] = ret+1;
            }

        }


        list2.add(arr[arr.length - 1]);
        dp2 = new int[arr.length];
        dp2[arr.length - 1] = 1;
        dp2[0] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (list2.get(list2.size() - 1) < arr[i]) {
                list2.add(arr[i]);
                dp2[i] = list2.size();
            } else {
                int ret = lowerBound(i, list2);
                list2.set(ret, arr[i]);
                dp2[i] = ret+1;
            }
        }

    }

    private static void output() {
        int ans = 0;
        for (int i = 0; i < dp1.length; i++) {
            ans = Math.max(dp1[i] + dp2[i] - 1, ans);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
