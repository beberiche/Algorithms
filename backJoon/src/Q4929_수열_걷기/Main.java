package Q4929_수열_걷기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, arr1[], arr2[], sum1[], sum2[], ans, visited[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;
    static List<Integer> list;
    static StringBuilder sb = new StringBuilder();

    private static void input() throws Exception {
        visited = new int[20004];
        list = new ArrayList<>();

        arr1 = new int[N];
        sum1 = new int[N];
        arr1[0] = Integer.parseInt(stk.nextToken());
        sum1[0] = arr1[0];
        visited[arr1[0] + 10000]++;
        for (int i = 1; i < N; i++) {
            arr1[i] = Integer.parseInt(stk.nextToken());
            visited[arr1[i] + 10000]++;
            sum1[i] = arr1[i];
            sum1[i] += sum1[i - 1];
        }
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        arr2 = new int[N];
        sum2 = new int[N];
        arr2[0] = Integer.parseInt(stk.nextToken());
        sum2[0] = arr2[0];

        if (visited[arr2[0] + 10000] > 0) {
            list.add(arr2[0]);
        }
        for (int i = 1; i < N; i++) {
            arr2[i] = Integer.parseInt(stk.nextToken());
            if (visited[arr2[i] + 10000] > 0) {
                list.add(arr2[i]);
            }
            sum2[i] = arr2[i];
            sum2[i] += sum2[i - 1];
        }
    }

    private static int binarySearch(int num, int[] arr) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private static void solve() {
        int idx1 = 0;
        int idx2 = 0;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < list.size(); i++) {
            int nIdx1 = binarySearch(list.get(i), arr1);
            int nIdx2 = binarySearch(list.get(i), arr2);
            num1 = sum1[nIdx1] - idx1;
            num2 = sum2[nIdx2] - idx2;
            ans += Math.max(num1, num2);
            idx1 = sum1[nIdx1];
            idx2 = sum2[nIdx2];
        }
        num1 = sum1[arr1.length - 1] - idx1;
        num2 = sum2[arr2.length - 1] - idx2;
        ans += Math.max(num1, num2);
        sb.append(ans).append("\n");
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            if (N == 0) break;
            input();
            ans = 0;
            solve();
        }
        output();
    }
}
