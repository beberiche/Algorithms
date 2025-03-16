package Q1500_최대_곱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        List<Long> list = new ArrayList<>();
        int val = S / K;
        int mod = S % K;
        for (int i = 0; i < K; i++) {
            Long num = (long) (i < mod ? val + 1 : val);
            list.add(num);
        }
        Long reduce = list.stream().reduce(1L, (n1, n2) -> n1 * n2);
        System.out.println(reduce);
    }
}
