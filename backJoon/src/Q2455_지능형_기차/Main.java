package Q2455_지능형_기차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int b = 0;
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(stk.nextToken());
            int in = Integer.parseInt(stk.nextToken());
            b = out == 0 ? in : b - out + in;
            cnt = Math.max(cnt, b);

        }
        System.out.println(cnt);
    }
}