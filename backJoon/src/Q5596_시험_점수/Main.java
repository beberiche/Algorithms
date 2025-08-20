package Q5596_시험_점수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        for(int i=0; i<2; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int sum =0;
            for(int j=0; j<4; j++) {
                int score = Integer.parseInt(stk.nextToken());
                sum += score;
            }
            ans = Math.max(ans, sum);
        }
        System.out.print(ans);
    }
}
