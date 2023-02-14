package Q9843_촛불_이벤트;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long A,B;
    private static void input() throws Exception{
        A = Long.parseLong(br.readLine());
        A*=2;
        B = (long)Math.sqrt(A);
    }
    private static void output(int t) {
        if(B*B+B==A) {
            System.out.println("#"+t+" "+B);
        } else {
            System.out.println("#"+t+" "+-1);
        }
    }
    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            input();
            output(t);
        }
    }
}
