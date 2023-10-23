package Q2831_댄스_파티;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 작은 여자를 선호하는 남자 - 큰 남자를 선호하는 여자.
// 큰 여자를 선호하는 남자 - 작은 남자를 선호하는 여자
// 각 쌍 정렬, 0,0 에서 시작
// 두 관게의 합 도출
public class Main {
    static int N, ans;
    static List<Integer> m0, m1, w0, w1;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m0 = new ArrayList<>();
        m1 = new ArrayList<>();
        w0 = new ArrayList<>();
        w1 = new ArrayList<>();
        N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if (num < 0) m0.add(-num);
            else m1.add(num);
        }

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if (num < 0) w0.add(-num);
            else w1.add(num);
        }

        Collections.sort(m0);
        Collections.sort(m1);
        Collections.sort(w0);
        Collections.sort(w1);
    }
    private static void solve() {
        // m0 - w1;
        // 작은 여자를 선호하는 남자 - 큰 남자를 선호하는 여자.
        int m = 0;
        int w = 0;
        while (m < m0.size() && w < w1.size()) {
            int curr_m = m0.get(m);
            int curr_w = w1.get(w);

            if (curr_m > curr_w) {
                ans++;
                m++;
                w++;
            } else if (curr_m <= curr_w) {
                m++;
            }
        }

        // m1 - w0;
        // 큰 여자를 선호하는 남자 - 작은 남자를 선호하는 여자
        m = 0;
        w = 0;
        while (m < m1.size() && w < w0.size()) {
            int curr_m = m1.get(m);
            int curr_w = w0.get(w);

            if (curr_m < curr_w) {
                ans++;
                m++;
                w++;
            } else if (curr_m >= curr_w) {
                w++;
            }
        }
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
