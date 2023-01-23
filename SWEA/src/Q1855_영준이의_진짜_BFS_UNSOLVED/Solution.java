package Q1855_영준이의_진짜_BFS_UNSOLVED;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Node {
        int val, d;
        Node p;
        ArrayList<Node> c = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }

        public void addChild(Node node) {
            node.d = d + 1;
            c.add(node);
        }
    }

    static int N, ans;
    static int[] p;
    static Node[] nodeArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());
            p = new int[N - 1];
            for (int i = 0; i < p.length; i++) p[i] = Integer.parseInt(stk.nextToken());
            nodeArr = new Node[N + 1];
            nodeArr[1] = new Node(1);
            ans = 0;
            for (int i = 2; i <= N; i++) {
                nodeArr[i] = new Node(i);
                nodeArr[i].p = nodeArr[p[i - 2]];
                nodeArr[p[i - 2]].addChild(nodeArr[i]);
            }

            ans = 0;
            bfs(nodeArr[1]);
            System.out.printf("#%d %d\n", t, ans);
        }
    }

    private static void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node prev = node;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node n : curr.c) {
                getDist(prev, n);
                prev = n;
                q.add(n);
            }
        }
    }

    private static void getDist(Node prev, Node curr) {
        prev = prev.d <= curr.d ? prev : curr;
        curr = prev.d > curr.d ? prev : curr;

        while (prev.d != curr.d) {
            curr = curr.p;
            ans += 1;
        }
        while (prev.val != curr.val) {
            prev = prev.p;
            curr = curr.p;
            ans += 2;
        }
    }
}
