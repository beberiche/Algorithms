package Q14746_Closest_Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        int c1 = Integer.parseInt(stk.nextToken());
        int c2 = Integer.parseInt(stk.nextToken());

        List<int[]> list = new ArrayList<>();

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(new int[]{Integer.parseInt(stk.nextToken()), 0});
        }

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            list.add(new int[]{Integer.parseInt(stk.nextToken()), 1});
        }

        int cnt = 0;
        int d = (int) 2e8;

        list.sort((n1, n2) -> n1[0] - n2[0]);

        int prevVal = list.get(0)[0];
        int prevState = list.get(0)[1];

        for (int i = 1; i < list.size(); i++) {
            int currVal = list.get(i)[0];
            int currState = list.get(i)[1];

            if (prevState != currState) {
                int diff = currVal - prevVal;
                if (diff < d) {
                    d = diff;
                    cnt = 1;
                } else if (diff == d) {
                    cnt++;
                }
            }

            prevVal = currVal;
            prevState = currState;
        }
        System.out.println(d + Math.abs(c1 - c2) + " " + cnt);
    }
}
