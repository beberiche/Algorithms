package Q1124_언더프라임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean[] prime = new boolean[100001];
        int[] cnt = new int[100001];
        prime[0] = prime[1] = true;
        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) continue;
            for (int j = i + i; j < prime.length; j += i) {
                prime[j] = true;
                int tmp = j;
                while (tmp % i == 0) {
                    tmp /= i;
                    cnt[j]++;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int st = Integer.parseInt(stk.nextToken());
        int ed = Integer.parseInt(stk.nextToken());

        int ret = 0;
        for (int i = st; i <= ed; i++) {
            if (!prime[cnt[i]]) ret++;
        }

        System.out.println(ret);
    }
}
