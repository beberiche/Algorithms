package Q16118_달빛_여우;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    static int N, M, MAX = 987654321;
    static List<double[]> list[];
    static PriorityQueue<double[]> pq;
    // 2개의 배열 만들기
    // 달빛 여우 용
    // 달빛 늑대가 on/off 상태를 모두 확인하는 2차원 배열
    // a : 달빛여우, b : 달빛늑대
    static double a[], b[][];
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int ed = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());

            list[st].add(new double[]{dist, ed});
            list[ed].add(new double[]{dist, st});
        }
    }

    private static void solve() {
        pq = new PriorityQueue<>((a, b) -> (int) a[0] - (int) b[0]);
        a = new double[N + 1];
        b = new double[N + 1][2];
        for (int i = 1; i <= N; i++) {
            a[i] = MAX;
            b[i][0] = MAX;
            b[i][1] = MAX;
        }
        // pq -> 달빛여우 :  {현재까지의 dist, 현재장소}
        //    -> 달빛늑대 :  {현재까지의 dist, 현재장소, 2배인지 느리게인지 (0,1)}
        pq.add(new double[]{0, 1});
        pq.add(new double[]{0, 1, 0});
        a[1] = 0;
        b[1][0] = 0;
        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            if(curr.length== 2 && a[(int) curr[1]] < curr[0]) continue;
            else if(curr.length > 2 && b[(int) curr[1]][(int) curr[2]] < curr[0]) continue;

            for (double[] next : list[(int) curr[1]]) {
                if (curr.length > 2) {
                    double nextDist = curr[2] == 0 ? next[0] / 2 : next[0] * 2;
                    double nextCheck = 1 - curr[2];
                    if (b[(int) next[1]][(int) nextCheck] > curr[0] + nextDist) {
                        b[(int) next[1]][(int) nextCheck] = curr[0] + nextDist;
                        pq.add(new double[]{b[(int) next[1]][(int) nextCheck], next[1], nextCheck});
                    }
                } else if (a[(int) next[1]] > curr[0] + next[0]) {
                    a[(int) next[1]] = curr[0] + next[0];
                    pq.add(new double[]{a[(int) next[1]], next[1]});
                }
            }
        }
    }

    private static void output() {
        int ans = 0;
        for (int i = 2; i <= N; i++) {
            if (a[i] < b[i][0] && a[i] < b[i][1]) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
