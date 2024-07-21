package Q13305_주유소;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dist = new long[N-1];
        long[] cost = new long[N];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N-1; i++) {
            dist[i] = Long.parseLong(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            cost[i] = Long.parseLong(stk.nextToken());
        }

        long sum = 0;
        long min = cost[0];

        for(int i=0; i<N-1; i++) {
            min = Math.min(cost[i], min);
            sum += min * dist[i];
        }

        System.out.println(sum);
    }
}
