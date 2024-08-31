package Q18513_샘터;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        Set<Integer> s = new HashSet<>();

        Queue<int[]> q = new LinkedList<>();
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(stk.nextToken());
            q.add(new int[]{p, 0});
            s.add(p);
        }

        long ans = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] + 1 <= 1e9 && !s.contains(curr[0] + 1)) {
                s.add(curr[0] + 1);
                q.add(new int[]{curr[0] + 1, curr[1] + 1});
                ans += curr[1] + 1;
                if (s.size() == K + N) break;
            }

            if (curr[0] - 1 >= -1e9 && !s.contains(curr[0] - 1)) {
                s.add(curr[0] - 1);
                q.add(new int[]{curr[0] - 1, curr[1] + 1});
                ans += curr[1] + 1;
                if (s.size() == K + N) break;
            }
        }

        System.out.println(ans);

    }
}
