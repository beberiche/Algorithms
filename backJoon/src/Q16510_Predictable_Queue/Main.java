package Q16510_Predictable_Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] a = new int[N + 1];
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(stk.nextToken());
            a[i] = a[i - 1] + num;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= M; i++) {
            int t = Integer.parseInt(br.readLine());

            int ret = binarySearch(a, t);
            sb.append(ret - 1).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int binarySearch(int[] a, int t) {
        int l = 0;
        int r = a.length;

        while (l < r) {
            int mid = (l + r) / 2;
            if (a[mid] > t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }
}
