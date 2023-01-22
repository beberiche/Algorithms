package Q1232_사칙연산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
    static class Node {
        String val;
        Node left;
        Node right;
    }

    public static void main(String[] args) throws Exception {
        int T = 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());
            Node nodeArr[] = new Node[N+1];
            StringTokenizer stk;
            for (int i = 0; i < N; i++) {
                stk = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(stk.nextToken());
                if (nodeArr[idx] == null) nodeArr[idx] = new Node();
                nodeArr[idx].val = stk.nextToken();
                if (stk.hasMoreTokens()) {
                    int left = Integer.parseInt(stk.nextToken());
                    int right = Integer.parseInt(stk.nextToken());
                    nodeArr[idx].left = nodeArr[left] = new Node();
                    nodeArr[idx].right = nodeArr[right] = new Node();
                }
            }
            sb.append(postOrder(nodeArr[1])).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int postOrder(Node node) {
        if (node.left == null || node.right == null) return Integer.parseInt(node.val);
        int left = postOrder(node.left);
        int right = postOrder(node.right);
        if (node.val.equals("-")) return left - right;
        else if (node.val.equals("+")) return left + right;
        else if (node.val.equals("/")) return left / right;
        else return left * right;
    }
}
