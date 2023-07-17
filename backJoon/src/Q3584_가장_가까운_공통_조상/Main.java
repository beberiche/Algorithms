package Q3584_가장_가까운_공통_조상;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 그래프 연결
// 두 노드의 depth 구하기, 부모 배열의 노드 값이 0인 애가 루트 노드
// 서로 깊이가 다른 경우, 더 깊은애를 덜 깊은 애와 깊이 맞추기
// 깊이가 동일한 경우, 부모가 동일할 때 까지 상위 부모 탐색
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;
    static StringBuffer sb = new StringBuffer();
    static int N, par[];
    static List<Integer> tree[];

    private static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        // 부모, 깊이
        par = new int[N + 1];
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            par[n2] = n1;
            tree[n1].add(n2);
        }
    }

    private static int getDepth(int node) {
        int cnt = 0;
        while (par[node] != 0) {
            node = par[node];
            cnt++;
        }
        return cnt;
    }

    private static int lca(int A, int B) {
        int nodeA = A;
        int nodeB = B;
        int ad = getDepth(A);
        int bd = getDepth(B);
        if (ad < bd) {
            nodeA = B;
            nodeB = A;
            int tmp = ad;
            ad = bd;
            bd = tmp;
        }

        while (ad != bd) {
            nodeA = par[nodeA];
            ad--;
        }

        while (nodeA != nodeB) {
            nodeA = par[nodeA];
            nodeB = par[nodeB];
        }
        return nodeA;
    }

    private static void solve() throws Exception {
        stk = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());
        int ans = lca(A, B);
        sb.append(ans).append("\n");
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
