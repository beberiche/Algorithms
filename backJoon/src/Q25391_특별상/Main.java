package Q25391_특별상;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        PriorityQueue<int[]> organizer = new PriorityQueue<>((n1, n2) -> n2[0] - n1[0]);
        PriorityQueue<int[]> referee = new PriorityQueue<>((n1, n2) -> n2[1] - n1[1]);

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(stk.nextToken());
            int r = Integer.parseInt(stk.nextToken());
            organizer.add(new int[]{o, r});
            referee.add(new int[]{o, r});
        }

        HashSet<Integer> s = new HashSet<>();
        long ret = 0;
        while (--K >= 0 && !referee.isEmpty()) {
            int[] curr = referee.poll();
            ret += curr[0];
            s.add(curr[0]);
        }

        int cnt = 0;
        while (!organizer.isEmpty()) {
            int[] curr = organizer.poll();
            if (s.contains(curr[0])) continue;

            ret += curr[0];
            cnt++;
            if (cnt == M) break;
        }
        System.out.println(ret);
    }
}
