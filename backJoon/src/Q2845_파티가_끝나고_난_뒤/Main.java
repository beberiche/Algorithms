package Q2845_파티가_끝나고_난_뒤;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(stk.nextToken());
        int p = Integer.parseInt(stk.nextToken());
        int num = l * p;
        stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (stk.hasMoreTokens()) {
            int n = Integer.parseInt(stk.nextToken());
            sb.append(n - num).append(" ");
        }
        System.out.print(sb);
    }
}
