package Q2997_네_번째_수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[3];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(a);
        int d1 = a[1] - a[0];
        int d2 = a[2] - a[1];
        int ans = -1;
        if (d1 == d2) {
            ans = a[2] + d1;
        } else if (d1 > d2) {
            ans = a[0] + d2;
        } else {
            ans = a[1] + d1;
        }
        System.out.println(ans);
    }
}
