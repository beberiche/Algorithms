package Q3151_합이_0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static int N, arr[];
    static long ans;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr);
    }

    private static int comb(int left, int right) {
        int ret = right - left;
        return (ret + 1) * (ret) / 2;
    }

    private static void solve() {
        for (int i = 0; i < N - 2; i++) {
            if (arr[i] > 0) break;

            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum > 0) right--;
                else if (sum < 0) left++;
                else {
                    if (arr[left] == arr[right]) {
                        ans += comb(left, right);
                        break;
                    } else {
                        int l = 1;
                        int r = 1;
                        while (left + 1 < right && arr[left] == arr[left + 1]) {
                            l++;
                            left++;
                        }

                        while (left < right - 1 && arr[right] == arr[right - 1]) {
                            r++;
                            right--;
                        }
                        ans += l * r;
                        left++;
                    }
                }
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
