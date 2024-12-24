package Q1673_치킨_쿠폰;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        while ((str = br.readLine()) != null) {
            StringTokenizer stk = new StringTokenizer(str);
            int n = Integer.parseInt(stk.nextToken());
            int k = Integer.parseInt(stk.nextToken());
            int temp = n, add_coupon = 0;
            while (temp >= k) {
                add_coupon += temp / k;
                temp = temp / k + temp % k;
            }
            sb.append(n + add_coupon).append("\n");
        }
        System.out.print(sb.toString());
    }
}
