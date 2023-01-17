package Q7964_부먹왕국의차원관문.Q10726_이진수_표현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int t=0;
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        while(++t<=T) {
            stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());
            sb.append("#").append(t).append(" ").append((M&(1<<N)-1) == (1<<N)-1? "ON" : "OFF").append("\n");
        }
        System.out.println(sb.toString());
    }
}
