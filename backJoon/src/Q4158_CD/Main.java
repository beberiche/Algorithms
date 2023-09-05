package Q4158_CD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr1[], arr2[], ans;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static void input() throws Exception {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        if(N==0 && M==0) {
            System.exit(0);
        }
        ans = 0;
        arr1 = new int[N];
        arr2 = new int[M];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr1[i] = num;
        }

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            arr2[i] = num;
        }
    }

    private static void binarySearch(int num) {
        int l = 0;
        int r = M - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr2[mid] == num) {
                ans++;
                break;
            } else if(l==r) {
                break;
            } else if (arr2[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
    }

    private static void output() {
        System.out.println(ans);
    }

    private static void solve() throws Exception {
        for (int i = 0; i < N; i++) {
            binarySearch(arr1[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        while(true) {
            input();
            solve();
            output();
        }
    }
}
