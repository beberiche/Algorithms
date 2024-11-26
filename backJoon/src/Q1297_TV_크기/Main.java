package Q1297_TV_크기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(stk.nextToken());
        int h = Integer.parseInt(stk.nextToken());
        int w = Integer.parseInt(stk.nextToken());

        double r = Math.sqrt(h * h + w * w);
        double width = d * w / r;
        double height = d * h / r;

        System.out.printf("%d %d", (int) height, (int) width);
    }
}
