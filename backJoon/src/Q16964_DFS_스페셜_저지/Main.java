package Q16964_DFS_스페셜_저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


// 주어진 DFS 방문 순서에 맞게 정렬
// 실제 DFS 시 순서에 맞게 출력되는지 확인
public class Main {
    static int N, order[], order2[], idx = 1;
    static List<Integer> list[];
    static boolean visited[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer stk;
        int n1, n2;
        for (int i = 0; i < N - 1; i++) {
            stk = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(stk.nextToken());
            n2 = Integer.parseInt(stk.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
        }


        order = new int[N + 1];

        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            order[Integer.parseInt(stk.nextToken())] = i;
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i], (l1, l2) -> order[l1] - order[l2]);
        }
        visited = new boolean[N + 1];
        order2 = new int[N + 1];
        visited[1] = true;
    }

    private static void output() {
        System.out.println(1);
    }

    private static void solve(int curr) {
        order2[curr] = idx++;

        if (order2[curr] != order[curr]) {
            System.out.println(0);
            System.exit(0);
        };

        for (int n : list[curr]) {
            if (visited[n]) continue;
            visited[n] = true;
            solve(n);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        solve(1);
        output();
    }
}
