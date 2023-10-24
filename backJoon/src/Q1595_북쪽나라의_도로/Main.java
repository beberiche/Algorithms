package Q1595_북쪽나라의_도로;


import java.util.*;

// 특정 도시를 두 번이상 지나지 않으며, 모든 도시로 이동이 가능하다. -> 사이클이 없는 그래프
// 트리의 지름 구하기
public class Main {
    static class Node {
        int next;
        int dist;

        Node(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }
    }

    static List<Node> list[];
    static boolean[] visited;
    static int[] ret;

    private static void input() {
        Scanner sc = new Scanner(System.in);

        list = new ArrayList[10001];
        for (int i = 1; i <= 10000; i++) {
            list[i] = new ArrayList<>();
        }


        StringTokenizer stk;
        while (true) {
            try {
                stk = new StringTokenizer(sc.nextLine());
                int n1 = Integer.parseInt(stk.nextToken());
                int n2 = Integer.parseInt(stk.nextToken());
                int dist = Integer.parseInt(stk.nextToken());
                list[n1].add(new Node(n2, dist));
                list[n2].add(new Node(n1, dist));

            } catch (Exception e) {
                break;
            }
        }
    }

    private static void dfs(int node, int dist) {
        visited[node] = true;

        if (ret[1] < dist) {
            ret[0] = node;
            ret[1] = dist;
        }

        for (Node n : list[node]) {
            if (visited[n.next]) continue;
            dfs(n.next, dist + n.dist);
        }
    }

    private static void solve() {
        visited = new boolean[10001];
        ret = new int[2];
        if(list[1].size()==0) {
            return;
        }

        dfs(1, 0);

        Arrays.fill(visited, false);
        dfs(ret[0], 0);
    }

    private static void output() {
        System.out.println(ret[1]);
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
