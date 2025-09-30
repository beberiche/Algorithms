package Q11023_더하기_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int num = 0;
        while (stk.hasMoreTokens()) {
            int n = Integer.parseInt(stk.nextToken());
            num += n;
        }
        System.out.print(num);
    }
}
