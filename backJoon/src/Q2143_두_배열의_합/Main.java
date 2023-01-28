package Q2143_두_배열의_합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
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
        int Apoint = 0;
        int Bpoint = BList.size() - 1;
        long ans = 0;
        while (Bpoint >= 0 && Apoint < AList.size()) {
            long sum = AList.get(Apoint) + BList.get(Bpoint);
            if (sum < T) {
                int curr = Apoint;
                while (Apoint < AList.size() && AList.get(Apoint) <= AList.get(curr)) Apoint++;
            } else if (sum > T) {
                int curr = Bpoint;
                while (Bpoint >=0 && BList.get(Bpoint) >= BList.get(curr)) Bpoint--;
            } else {
                int currA = Apoint;
                int currB = Bpoint;
                long cntA = 0;
                long cntB = 0;
                while (Apoint < AList.size() && AList.get(Apoint) <= AList.get(currA)) {
                    Apoint++;
                    cntA++;
                }
                while (Bpoint >=0 && BList.get(Bpoint) >= BList.get(currB)) {
                    Bpoint--;
                    cntB++;
                }
                ans += cntA * cntB;
            }
        }
        System.out.println(ans);
    }
}
