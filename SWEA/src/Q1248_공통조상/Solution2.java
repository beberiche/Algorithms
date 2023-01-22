package Q1248_공통조상;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
    static class Node {
        int p;
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static int V,E,n1,n2,root,cnt;
    static Node[] nodeArr;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            stk = new StringTokenizer(br.readLine());
            V = Integer.parseInt(stk.nextToken());
            E = Integer.parseInt(stk.nextToken());
            n1 = Integer.parseInt(stk.nextToken());
            n2 = Integer.parseInt(stk.nextToken());

            nodeArr = new Node[V + 1];
            for (int i = 1; i <= V; i++) nodeArr[i] = new Node(i);

            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int p = Integer.parseInt(stk.nextToken());
                int c = Integer.parseInt(stk.nextToken());
                if (nodeArr[p].left == null) {
                    nodeArr[c].p = p;
                    nodeArr[p].left = nodeArr[c];
                } else {
                    nodeArr[c].p = p;
                    nodeArr[p].right = nodeArr[c];
                }
            }

            visited = new boolean[V + 1];

            root = 1;
            while (true) {
                if (n1 != 1) {
                    int n1p = nodeArr[n1].p;
                    if (visited[n1p]) {
                        root = n1p;
                        break;
                    }
                    visited[n1p] = true;
                    n1 = n1p;

                }
                if (n2 != 1) {
                    int n2p = nodeArr[n2].p;
                    if (visited[n2p]) {
                        root = n2p;
                        break;
                    }
                    visited[n2p] = true;
                    n2 = n2p;
                }
            }

            sb.append(root).append(" ");
            cnt = 0;
            inOrder(nodeArr[root]);
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void inOrder(Node node) {
        if (node == null) return;
        cnt++;
        inOrder(node.left);
        inOrder(node.right);
    }
}
