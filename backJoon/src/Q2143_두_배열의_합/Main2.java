package Q2143_두_배열의_합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
    static int T, N, M;
    static int[] A, B;
    static List<Long> AList, BList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stk.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        B = new int[M];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(stk.nextToken());
        }

        AList = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            long tmp = 0;
            for (int j = i; j < A.length; j++) {
                tmp += A[j];
                AList.add(tmp);
            }
        }

        BList = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            long tmp = 0;
            for (int j = i; j < B.length; j++) {
                tmp += B[j];
                BList.add(tmp);
            }
        }

        Collections.sort(AList);
        Collections.sort(BList);

        long ans = 0;
        for (int i = 0; i < AList.size();) {
            long val = AList.get(i);
            long a = upperBound(AList, val) - lowerBound(AList, val);
            long b = upperBound(BList, T-val) - lowerBound(BList, T-val);
            ans += a*b;
            i += a;
        }
        System.out.println(ans);
    }

    private static int upperBound(List<Long> list, long val) {
        int st = 0;
        int ed = list.size();
        while (st < ed) {
            int mid = (st + ed) / 2;
            if (list.get(mid) <= val) {
                st = mid + 1;
            } else {
                ed = mid;
            }
        }
        return ed;
    }

    private static int lowerBound(List<Long> list, long val) {
        int st = 0;
        int ed = list.size();
        while (st < ed) {
            int mid = (st + ed) / 2;
            if (list.get(mid) >= val) {
                ed = mid;
            } else {
                st = mid + 1;
            }
        }
        return ed;
    }
}
