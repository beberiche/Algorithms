package Q1231_중위순회;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
    static class Node {
        char ch;
        Node left;
        Node right;
    }

    static int N;
    static Node[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int T = 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            arr = new Node[N + 1];
            for (int i = 0; i < N; i++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(stk.nextToken());
                char ch = stk.nextToken().charAt(0);

                if(arr[idx] == null) arr[idx] = new Node();
                arr[idx].ch = ch;
                if (stk.hasMoreTokens()) {
                    int left = Integer.parseInt(stk.nextToken());
                    arr[left] = new Node();
                    arr[idx].left = arr[left];
                }
                if (stk.hasMoreTokens()) {
                    int right = Integer.parseInt(stk.nextToken());
                    arr[right] = new Node();
                    arr[idx].right = arr[right];
                }
            }
            inOrder(arr[1]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void inOrder(Node node) {
        if(node == null) return;

        inOrder(node.left);
        sb.append(node.ch);
        inOrder(node.right);
    }
}
