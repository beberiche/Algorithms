package Q8111_0과_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, visited[];

    static class Node {
        int num;
        String str;

        Node(int num, String str) {
            this.num = num;
            this.str = str;
        }
    }

    private static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        visited = new int[N];
    }

    private static void solve() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, "1"));
        visited[1]++;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.num == 0) {
                sb.append(curr.str).append("\n");
                break;
            } else if (curr.str.length() > 100) {
                sb.append("BRAK").append("\n");
                break;
            }

            if (visited[(curr.num * 10 + 1) % N] == 0) {
                visited[(curr.num * 10 + 1) % N]++;
                q.add(new Node((curr.num * 10 + 1) % N, curr.str + "1"));
            }
            if (visited[(curr.num * 10) % N] == 0) {
                visited[(curr.num * 10) % N]++;
                q.add(new Node((curr.num * 10) % N, curr.str + "0"));
            }
        }
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
