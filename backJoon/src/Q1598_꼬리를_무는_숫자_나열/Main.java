package Q1598_꼬리를_무는_숫자_나열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(stk.nextToken()) - 1;
        int b = Integer.parseInt(stk.nextToken()) - 1;

        int ans = 0;
        ans += Math.abs(a/4 - b/4);
        ans += Math.abs(a%4 - b%4);

        System.out.println(ans);
    }
}
