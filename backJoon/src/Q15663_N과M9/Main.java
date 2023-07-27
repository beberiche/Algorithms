package Q15663_N과M9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

// 중복 순열 단, 자기 자신은 제외
// 순서를 위해 정렬
// HashMap을 통한 답 방문 처리, visited를 통한 인덱스 방문 처리
public class Main {
    static HashSet<String> s = new HashSet<>();
    static int N, M, arr[], visited[];
    static StringBuffer sb = new StringBuffer();

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        arr = new int[N];
        visited = new int[N];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
    }


    private static void go(String str, int d) {
        if (d >= M) {
            if (!s.contains(str)) {
                s.add(str);
                sb.append(str);
                sb.append("\n");
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] > 0) continue;
            visited[i]++;
            go(str.length() == 0 ? String.valueOf(arr[i]) : str + " " + String.valueOf(arr[i]), d + 1);
            visited[i]--;
        }
    }

    private static void solve() {
        go("", 0);
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
