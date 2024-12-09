package Q1453_피시방_알바;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] a = new boolean[104];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int ret = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if (a[num]) {
                ret++;
                continue;
            }

            a[num] = true;
        }
        System.out.println(ret);
    }
}
