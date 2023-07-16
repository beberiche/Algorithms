package Q19542_전단지_돌리기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// DFS를 활용한 가지고 있는 자식 중 최대 깊이 구하기
// 다음 가야할 자식 노드의 깊이가 D 이하면 그 노드는 안가도됨
// (총 방문한 자식 노드) * 2 가 현민이의 이동거리
public class Main {
    static int N, S, D, depth[], visited[], ans;
    static List<Integer> tree[];


    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        S = Integer.parseInt(stk.nextToken());
        D = Integer.parseInt(stk.nextToken());
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        // 못 가는 곳은 없다고 했으니,
        // 총 간선은 N-1 개 일 것이다.
        for (int i = 1; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int ed = Integer.parseInt(stk.nextToken());
            tree[st].add(ed);
            tree[ed].add(st);
        }
    }

    // 노드가 가진 자식 중 가장 깊은 자식 깊이 찾기
    private static int getMaxDepth(int node) {
        visited[node]++;
        int ret = 0;
        for (int child : tree[node]) {
            if (visited[child] > 0) continue;
            ret = Math.max(ret, getMaxDepth(child));
        }
        depth[node] = ret;
        if (ret >= D && node != S) ans++;
        return ret + 1;
    }

//    private static void go(int node) {
//        Queue<Integer> q = new LinkedList<>();
//        q.add(node);
//        Arrays.fill(visited, 0);
//        while (!q.isEmpty()) {
//            int curr = q.poll();
//            visited[curr]++;
//            for (int next : tree[curr]) {
//                if (visited[next] > 0 || depth[next] <= D - 1) continue;
//                q.add(next);
//                ans++;
//            }
//        }
//    }

    private static void solve() {
        depth = new int[N + 1];
        visited = new int[N + 1];
        getMaxDepth(S);
//        go(S);
    }

    private static void output() {
        System.out.println(ans * 2);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
