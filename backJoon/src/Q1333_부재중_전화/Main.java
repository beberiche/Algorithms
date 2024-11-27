package Q1333_부재중_전화;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int L = Integer.parseInt(stk.nextToken());
        int D = Integer.parseInt(stk.nextToken());

        boolean[] b = new boolean[N * L + (N - 1) * 5];

        for (int i = 0; i < N; i++) {
            int st = (L + 5) * i;
            for (int j = st; j < st + L; j++) b[j] = true;
        }

        int ret = 0;
        while (ret < b.length) {
            if (!b[ret]) break;
            ret += D;
        }
        System.out.println(ret);
    }
}
