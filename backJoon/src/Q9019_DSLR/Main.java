package Q9019_DSLR;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 최소한의 명령어 -> BFS
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int A, B, visited[];

    static class Node {
        int val;
        String str;

        Node(int val, String str) {
            this.val = val;
            this.str = str;
        }
    }

    private static void input() throws Exception {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        A = Integer.parseInt(stk.nextToken());
        B = Integer.parseInt(stk.nextToken());
    }


    private static Node calcD(Node node) {
        int newVal = (node.val * 2) % 10000;
        return new Node(newVal, node.str + "D");
    }

    private static Node calcS(Node node) {
        int newVal = node.val == 0 ? 9999 : node.val - 1;
        return new Node(newVal, node.str + "S");
    }

    private static Node calcL(Node node) {
        int newVal = (node.val % 1000) * 10 + node.val / 1000;
        return new Node(newVal, node.str + "L");
    }

    private static Node calcR(Node node) {
        int newVal = (node.val % 10) * 1000 + node.val / 10;
        return new Node(newVal, node.str + "R");
    }

    private static void solve() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(A, ""));
        visited = new int[10000];
        visited[A]++;
        Node newNode1, newNode2, newNode3, newNode4;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.val == B) {
                System.out.println(curr.str);
                return;
            }

            newNode1 = calcD(curr);
            newNode2 = calcS(curr);
            newNode3 = calcL(curr);
            newNode4 = calcR(curr);
            if (visited[newNode1.val] == 0) {
                visited[newNode1.val]++;
                q.add(newNode1);
            }
            if (visited[newNode2.val] == 0) {
                visited[newNode2.val]++;
                q.add(newNode2);
            }
            if (visited[newNode3.val] == 0) {
                visited[newNode3.val]++;
                q.add(newNode3);
            }
            if (visited[newNode4.val] == 0) {
                visited[newNode4.val]++;
                q.add(newNode4);
            }
        }
    }



    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            input();
            solve();
        }
    }
}
