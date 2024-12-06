package Q1408_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), ":");
        int h = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int s = Integer.parseInt(stk.nextToken());

        int now = (h * 3600) + (m * 60) + s;

        stk = new StringTokenizer(br.readLine(), ":");
        h = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        s = Integer.parseInt(stk.nextToken());

        int start = (h * 3600) + (m * 60) + s;

        int time;
        if (start > now) {
            time = start - now;
        } else {
            time = (24 * 3600) - (now - start);
        }
        System.out.format("%02d:%02d:%02d", (time / 3600), ((time / 60) % 60), (time % 60));
    }
}
