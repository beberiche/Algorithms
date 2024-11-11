package Q11067_모노톤길;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (--T >= 0) {
            List<int[]> list = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer stk;
            for (int i = 0; i < N; i++) {
                stk = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());
                list.add(new int[]{x, y});
            }
            list.add(new int[]{-1, 0});

            Collections.sort(list, (n1, n2) -> {
                if (n1[0] == n2[0]) return n1[1] - n2[1];
                return n1[0] - n2[0];
            });

            int idx = 1;
            while (idx <= N) {
                if (list.get(idx)[0] == list.get(idx - 1)[0] || list.get(idx)[1] == list.get(idx - 1)[1]) {
                    idx++;
                } else {
                    int curr = idx;
                    int currX = list.get(idx)[0];

                    while (idx <= N && currX == list.get(idx)[0]) {
                        idx++;
                    }

                    List<int[]> subList = list.subList(curr, idx);
                    Collections.reverse(subList);
                }
            }
            stk = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(stk.nextToken());
            for (int i = 0; i < M; i++) {
                int index = Integer.parseInt(stk.nextToken());
                sb.append(list.get(index)[0]).append(" ").append(list.get(index)[1]).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
