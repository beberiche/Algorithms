package Q1393_음하철도_구구팔;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        int xe = Integer.parseInt(stk.nextToken());
        int ye = Integer.parseInt(stk.nextToken());
        int dx = Integer.parseInt(stk.nextToken());
        int dy = Integer.parseInt(stk.nextToken());
        int mdx = Math.abs(dx);
        int mdy = Math.abs(dy);

        if (dx == 0 && dy == 0) {
            System.out.printf("%d %d", xe, ye);
            return;
        }

        int min = Math.min(mdx, mdy);
        int max = Math.max(mdx, mdy);

        int gcd = gcd(min, max);

        dx /= gcd;
        dy /= gcd;

        long minDist = (long) (xe - x) * (xe - x) + (long) (ye - y) * (ye - y);
        int minX = xe, minY = ye;
        while (true) {
            xe += dx;
            ye += dy;

            long nextDist = (long) (xe - x) * (xe - x) + (long) (ye - y) * (ye - y);
            if (nextDist < minDist) {
                minDist = nextDist;
                minX = xe;
                minY = ye;
            } else {
                break;
            }
        }
        System.out.printf("%d %d", minX, minY);

    }

    private static int gcd(int n1, int n2) {
        while (n2 != 0) {
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1;
    }
}
