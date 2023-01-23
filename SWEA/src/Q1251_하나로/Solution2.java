package Q1251_하나로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2 {

    static int N;
    static int[] p;
    static int[] row, column;
    static long ans;
    static double E;

    static class Node {
        int x, y;
        long c;

        public Node(int x, int y, long c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    static List<Node> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            p = new int[N];
            ans = 0;
            for (int i = 0; i < N; i++) p[i] = i;
            StringTokenizer stkR = new StringTokenizer(br.readLine());
            StringTokenizer stkC = new StringTokenizer(br.readLine());
            row = new int[N];
            column = new int[N];
            for (int i = 0; i < N; i++) {
                row[i] = Integer.parseInt(stkR.nextToken());
                column[i] = Integer.parseInt(stkC.nextToken());
            }
            E = Double.parseDouble(br.readLine());
            map = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    long costR = Math.abs(row[i] - row[j]);
                    long costC = Math.abs(column[i] - column[j]);
                    long cost = costR * costR + costC * costC;
                    map.add(new Node(i, j, cost));
                    map.add(new Node(j, i, cost));
                }
            }
            Collections.sort(map, (n1, n2) -> Long.compare(n1.c, n2.c));
            for (int i = 0; i < map.size(); i++) {
                Node curr = map.get(i);
                int currX = findSet(curr.x);
                int currY = findSet(curr.y);
                if (currX == currY) continue;
                p[currY] = currX;
                ans += curr.c;
            }
            sb.append(Math.round(ans * E)).append("\n");
        }
        System.out.print(sb);
    }

    private static int findSet(int n) {
        if (n == p[n]) return n;
        return p[n] = findSet(p[n]);
    }
}
