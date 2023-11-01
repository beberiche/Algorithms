package Q4343_Arctic_Network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int st;
        int ed;
        double dist;

        Node(int st, int ed, double dist) {
            this.st = st;
            this.ed = ed;
            this.dist = dist;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;
    static int S, P, arr[][], p[];
    static PriorityQueue<Node> pq;
    static StringBuilder sb = new StringBuilder();

    private static void input() throws Exception {
        stk = new StringTokenizer(br.readLine());
        S = Integer.parseInt(stk.nextToken());
        P = Integer.parseInt(stk.nextToken());

        arr = new int[P][2];
        for (int i = 0; i < P; i++) {
            stk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(stk.nextToken());
            arr[i][1] = Integer.parseInt(stk.nextToken());
        }


        pq = new PriorityQueue<>((n1, n2) -> (int) (n1.dist - n2.dist));
        for (int i = 0; i < P - 1; i++) {
            for (int j = i + 1; j < P; j++) {
                double dist = Math.sqrt(Math.pow(arr[i][0] - arr[j][0], 2) + Math.pow(arr[i][1] - arr[j][1], 2));
                pq.add(new Node(i, j, dist));

            }
        }
    }


    private static int find(int num) {
        if (p[num] == num) {
            return num;
        }
        return p[num] = find(p[num]);
    }

    private static void solve() {
        int cnt = P - S;
        p = new int[P];
        for (int i = 0; i < P; i++) {
            p[i] = i;
        }
        double ans = 0;
        while (!pq.isEmpty() && cnt > 0) {
            Node curr = pq.poll();

            int x = find(curr.st);
            int y = find(curr.ed);
            if (x != y) {
                p[y] = x;
                ans = curr.dist;
                cnt--;
            }
        }

        sb.append(String.format("%.2f", ans)).append("\n");
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            input();
            solve();
        }
        output();
    }
}
