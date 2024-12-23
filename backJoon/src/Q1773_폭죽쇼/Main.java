package Q1773_폭죽쇼;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int C = Integer.parseInt(stk.nextToken());

        int[] a = new int[N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        for (int j = 1; j <= C; j++) {
            for (int i = 0; i < N; i++) {
                int x = j % a[i];
                if (x == 0) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
