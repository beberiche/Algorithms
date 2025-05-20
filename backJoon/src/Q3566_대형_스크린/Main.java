package Q3566_대형_스크린;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int rh = Integer.parseInt(stk.nextToken());
        int rv = Integer.parseInt(stk.nextToken());
        int sh = Integer.parseInt(stk.nextToken());
        int sv = Integer.parseInt(stk.nextToken());
        int sz = Integer.parseInt(br.readLine());

        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < sz; i++) {
            stk = new StringTokenizer(br.readLine());
            int rhi = Integer.parseInt(stk.nextToken());
            int rvi = Integer.parseInt(stk.nextToken());
            int shi = Integer.parseInt(stk.nextToken());
            int svi = Integer.parseInt(stk.nextToken());
            int pi = Integer.parseInt(stk.nextToken());

            int horizontal = Math.max((int) Math.ceil((double) rh / rhi), (int) Math.ceil((double) sh / shi));
            int vertical = Math.max((int) Math.ceil((double) rv / rvi), (int) Math.ceil((double) sv / svi));
            minPrice = Math.min(minPrice, horizontal * vertical * pi);

            horizontal = Math.max((int) Math.ceil((double) rh / rvi), (int) Math.ceil((double) sh / svi));
            vertical = Math.max((int) Math.ceil((double) rv / rhi), (int) Math.ceil((double) sv / shi));
            minPrice = Math.min(minPrice, horizontal * vertical * pi);
        }

        System.out.println(minPrice);
    }
}