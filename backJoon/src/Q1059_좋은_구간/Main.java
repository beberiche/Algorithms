package Q1059_좋은_구간;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] a = new int[L];
        for (int i = 0; i < L; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }
        int N = Integer.parseInt(br.readLine());
        // 1. 정렬
        Arrays.sort(a);

        // 2. lowerbound
        int idx = lowerBound(a, N);

        // 3. 갯수 구하기
        if (idx == -1) {
            System.out.println(go(0, N, a[0])); // st가 1이라면 1을 포함하고 카운트 한다.
        } else if(a[idx] == N) {
            System.out.println(0);
        }else if (idx == L - 1) {
            System.out.println(go(a[idx], N, 1001)); // ed가 1000이라면 1000을 포함하고 카운트한다.
        } else {
            System.out.println(go(a[idx], N, a[idx + 1]));
        }
    }

    private static int go(int st, int mid, int ed) {
        int ret = 0;
        for (int i = st + 1; i <= mid; i++) {
            for (int j = mid; j < ed; j++) {
                ret++;
            }
        }
        return ret-1;
    }

    private static int lowerBound(int[] a, int n) {
        int l = 0;
        int r = a.length - 1;

        int ret = -1;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (a[mid] <= n) {
                ret = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ret;
    }
}
