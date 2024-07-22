package Q9694_무엇을_아느냐가_아니라_누구를_아느냐가_문제다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 다익스트라
        // 이전노드 배열과 비용 배열 만들기
        // 현재 노드에 도달하기 지니고 있던 최솟값보다, 다른 최솟값이 등장한다면 이전노드와 비용을 업데이트
        // M-1 에 도달하지 못하는 경우는 -1 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for (int t = 1; t <= T; t++) {
            sb.append("Case #").append(t).append(": ");

            StringTokenizer stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());

            List<int[]> list[] = new ArrayList[M];

            for (int i = 0; i < M; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < N; i++) {
                stk = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(stk.nextToken());
                int n2 = Integer.parseInt(stk.nextToken());
                int dist = Integer.parseInt(stk.nextToken());

                list[n1].add(new int[]{n2, dist});
                list[n2].add(new int[]{n1, dist});
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
            int[] prev = new int[M];
            int[] dist = new int[M];

            Arrays.fill(prev, -1);
            Arrays.fill(dist, (int) 1e9);
            dist[0] = 0;

            pq.add(new int[]{0, 0});

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();

                for (int[] next : list[curr[0]]) {
                    if (dist[next[0]] > curr[1] + next[1]) {
                        dist[next[0]] = curr[1] + next[1];
                        prev[next[0]] = curr[0];
                        pq.add(new int[]{next[0], dist[next[0]]});
                    }
                }
            }

            int goal = M - 1;

            if (prev[goal] == -1) {
                sb.append("-1");
            } else {
                Stack<Integer> s = new Stack<>();
                s.push(goal);
                while (prev[goal] != -1) {
                    s.push(prev[goal]);
                    goal = prev[goal];
                }
                while(!s.isEmpty()) {
                    sb.append(s.pop()).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
