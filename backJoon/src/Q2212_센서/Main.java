package Q2212_센서;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 센서 값 정렬
// 각 센서 별 차에 대한 cnt 배열 생성
// cnt 배열 뒤에서 부터 반복문, K 가 존재하면 continue, K=0이면 더하기
// 총 더해진 값이 정답
public class Main {
    static int N, K, a[], cnt[], max = -1, ans;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
            max = Math.max(max, a[i]);
        }
    }

    private static void solve() {
        Arrays.sort(a);
        cnt = new int[max + 1];
        for (int i = 0; i < N - 1; i++) {
            cnt[a[i + 1] - a[i]]++;
        }
        K--;
        for (int i = cnt.length - 1; i >= 0; i--) {
            int curr = cnt[i];
            while (curr-- > 0) {
                if (K > 0) K--;
                else ans += i;
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
