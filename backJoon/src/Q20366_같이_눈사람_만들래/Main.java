package Q20366_같이_눈사람_만들래;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[], ans = 1_000_000_000 + 4;

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

    private static void solve() {
        outer:
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 3; j < arr.length; j++) {
                if (i + 3 >= arr.length) continue;

                int l = i + 1;
                int r = j - 1;

                while (l < r) {
                    int A = arr[i] + arr[j];
                    int B = arr[l] + arr[r];
                    ans = Math.min(Math.abs(A - B), ans);

                    if (A < B) r--;
                    else if (A > B) l++;
                    else break outer;
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
