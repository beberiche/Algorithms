package Q1357_뒤집힌_덧셈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb1 = new StringBuilder(stk.nextToken()).reverse();
        StringBuilder sb2 = new StringBuilder(stk.nextToken()).reverse();

        int sum = Integer.parseInt(sb1.toString()) + Integer.parseInt(sb2.toString());
        StringBuilder sb3 = new StringBuilder(String.valueOf(sum)).reverse();
        System.out.print(Integer.parseInt(sb3.toString()));
    }
}
