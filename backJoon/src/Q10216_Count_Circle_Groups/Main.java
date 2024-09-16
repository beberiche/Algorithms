package Q10216_Count_Circle_Groups;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static Node a[];
    private static int p[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(stk.nextToken());

        StringBuilder sb = new StringBuilder();
        while (--T >= 0) {
            int N = Integer.parseInt(br.readLine());

            a = new Node[N + 1];

            p = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                p[i] = i;
            }

            for (int i = 1; i <= N; i++) {
                stk = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(stk.nextToken());
                int c = Integer.parseInt(stk.nextToken());
                int d = Integer.parseInt(stk.nextToken());

                a[i] = new Node(i, r, c, d);
            }


            for (int i = 1; i <= N - 1; i++) {
                for (int j = i + 1; j <= N; j++) {

                    int x = find(p[i]);
                    int y = find(p[j]);

                    if (x == y) continue;

                    Node n1 = a[i];
                    Node n2 = a[j];

                    double range = Math.pow(n1.dist + n2.dist, 2);
                    double dist = Math.pow(n1.r - n2.r, 2) + Math.pow(n1.c - n2.c, 2);

                    if (range >= dist) {
                        p[y] = x;
                    }
                }
            }

            Set<Integer> s = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                s.add(find(p[i]));
            }

            sb.append(s.size()).append("\n");
        }

        System.out.print(sb.toString());
    }

    private static class Node {
        int id, r, c, dist;

        Node(int id, int r, int c, int dist) {
            this.id = id;
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    private static int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }
}
