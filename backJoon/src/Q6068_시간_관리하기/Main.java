package Q6068_시간_관리하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] a = new int[N][];

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            a[i] = new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};
        }

        Arrays.sort(a, (n1, n2) -> n2[1] - n1[1]);

        int ans = a[0][1];

        for (int i = 0; i < N; i++) {
            if (ans >= a[i][1]) {
                ans = a[i][1] - a[i][0];
            } else {
                ans -= a[i][0];
            }
        }

        System.out.println(ans >= 0 ? ans : -1);
    }
}
