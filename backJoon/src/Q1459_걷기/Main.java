package Q1459_걷기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        long x = Long.parseLong(stk.nextToken());
        long y = Long.parseLong(stk.nextToken());
        long w = Long.parseLong(stk.nextToken());
        long s = Long.parseLong(stk.nextToken());

        long ret = Long.MAX_VALUE;

        ret = Math.min(ret, (x + y) * w);

        if ((x + y) % 2 == 0) {
            ret = Math.min(ret, Math.max(x, y) * s);
        } else {
            ret = Math.min(ret, (Math.max(x, y) - 1) * s + w);
        }

        ret = Math.min(ret, Math.min(x, y) * s + Math.abs(x - y) * w);
        System.out.println(ret);
    }
}
