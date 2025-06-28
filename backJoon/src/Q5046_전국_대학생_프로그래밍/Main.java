package Q5046_전국_대학생_프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());
        int h = Integer.parseInt(stk.nextToken());
        int w = Integer.parseInt(stk.nextToken());

        int[] hotel = new int[h];
        int[] minCost = new int[h];

        for (int i = 0; i < h; i++) {
            hotel[i] = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                int room = Integer.parseInt(stk.nextToken());
                if (room >= n) {
                    if (hotel[i] * n < min) {
                        min = hotel[i] * n;
                    }
                }
                minCost[i] = min;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < minCost.length; i++) {
            if (minCost[i] < min) {
                min = minCost[i];
            }
        }

        System.out.print(min > b ? "stay home" : min);
    }
}
