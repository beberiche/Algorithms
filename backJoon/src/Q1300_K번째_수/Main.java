package Q1300_K번째_수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        int st = 1;
        int ed = K;
        while (st<ed) {
            int mid = (st + ed) / 2;
            int cnt = 0;
            for (int i = 1; i <= N; i++) cnt += Math.min(N, mid/i);
            if (cnt>=K) ed = mid;
            else st = mid+1;
        }
        System.out.println(ed);
    }
}
