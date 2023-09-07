package Q9489_사촌;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 트리 형성하기
// 현재 노드에서 2칸 부모로 올라간 후, 자신의 부모가 아닌 다른 부모들이 가진 자식들 계산
// 부모 구하기 depth[d-1].get(currCnt);

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, K, p[], c[], goalIdx;
    static List<Integer> list;
    static StringTokenizer stk;

    private static void input() throws Exception {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        if (N == 0 && K == 0) {
            output();
            System.exit(0);
        }

        list = new ArrayList<>();

        stk = new StringTokenizer(br.readLine());
        list.add(Integer.parseInt(stk.nextToken()));

        p = new int[N];
        c = new int[N];
        int idx = -1;
        p[0] = -1;
        goalIdx = 0;
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if (list.get(i - 1) + 1 < num) idx++;
            if (num == K) goalIdx = i;
            p[i] = idx;
            c[p[i]]++;
            list.add(num);
        }
    }

    private static void output() {
        System.out.print(sb.toString());
    }


    private static void solve() {
        if (p[goalIdx] == -1 || p[p[goalIdx]] == -1) {
            sb.append(0).append("\n");
            return;
        }

        int ans = 0;
        for (int i = 0; i < goalIdx; i++) {
            if (p[i] > p[p[goalIdx]]) break;
            if (p[i] == p[p[goalIdx]]) {
                if (i != p[goalIdx]) ans += c[i];
            }
        }
        sb.append(ans).append("\n");
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            input();
            solve();
        }
    }
}
