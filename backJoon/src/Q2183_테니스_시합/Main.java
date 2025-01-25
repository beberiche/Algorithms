package Q2183_테니스_시합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        stk.nextToken();	//인원 수 N
        StringBuilder sb = new StringBuilder();
        sb.append(stk.nextToken());
        System.out.println(sb.charAt(sb.length()-1));
    }
}
