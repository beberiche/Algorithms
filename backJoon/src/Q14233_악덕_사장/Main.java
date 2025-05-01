package Q14233_악덕_사장;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(a);

        int l = 1;
        int r = a[0];

        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid, a)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(r);
    }

    private static boolean check(int mid, int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += mid;
            if (a[i] < sum) return false;
        }
        return true;
    }
}
