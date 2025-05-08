package Q3046_R2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int R1 = Integer.parseInt(stk.nextToken());
        int S = Integer.parseInt(stk.nextToken());
        System.out.print((2 * S) - R1);
    }
}
