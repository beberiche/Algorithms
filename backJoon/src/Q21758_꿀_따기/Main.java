package Q21758_꿀_따기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[], reverse[], sum[], sum2[], ans;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        reverse = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            reverse[N - i - 1] = arr[i];
        }

        sum = new int[N];
        sum2 = new int[N];

        sum[0] = arr[0];
        sum2[0] = reverse[0];
        for (int i = 1; i < N; i++) {
            sum[i] += sum[i - 1] + arr[i];
            sum2[i] += sum2[i - 1] + reverse[i];
        }
    }

    private static void solve() {
        int Asum = sum[N - 1] - sum[0];
        int Asum2 = sum2[N - 1] - sum2[0];

        for (int i = 1; i < N - 1; i++) {

            // A벌과 벌통을 양끝에
            // B벌은 A벌 ~ 벌통 사이의 모든 경우의 수를 탐색,
            Asum -= arr[i];
            int Bsum = sum[N - 1] - sum[i];
            if (Asum + Bsum > ans) ans = Asum + Bsum;
            Asum += arr[i];

            // A벌과 벌통이 반대가 되는 경우
            Asum2 -= reverse[i];
            int Bsum2 = sum2[N - 1] - sum2[i];
            if (Asum2 + Bsum2 > ans) ans = Asum2 + Bsum2;
            Asum2 += reverse[i];

            // A,B벌을 양끝에, 벌통을 중간에 놓았을 때,
            if (sum[i] - sum[0] + sum[N - 2] - sum[i - 1] > ans) {
                ans = sum[i] - sum[0] + sum[N - 2] - sum[i - 1];
            }

            // A벌과 B벌이 반대가 되는 경우,
            if (sum2[i] - sum2[0] + sum2[N - 2] - sum2[i - 1] > ans) {
                ans = sum2[i] - sum2[0] + sum2[N - 2] - sum2[i - 1];
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
