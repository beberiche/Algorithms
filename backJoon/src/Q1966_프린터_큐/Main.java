package Q1966_프린터_큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int T, N, M, ans;
    static Queue<int[]> q;
    static int[] cntArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while (--T >= 0) {
            q = new LinkedList<>();
            N = sc.nextInt();
            M = sc.nextInt();
            ans = 0;
            int num;
            cntArr = new int[10];
            for (int i = 0; i < N; i++) {
                num = sc.nextInt();
                q.add(new int[]{num, i});
                cntArr[num]++;
            }

            outer:
            while (!q.isEmpty()) {
                for (int i = 9; i >= 1; i--) {
                    if(cntArr[i]==0) continue;
                    int len = q.size();
                    int cnt = 0;
                    while (cnt < len) {
                        int[] curr = q.poll();
                        if (curr[0] == i) {
                            ans++;
                            if (curr[1] == M) break outer;
                            if (--cntArr[i] == 0) break;
                        } else {
                            q.add(curr);
                        }
                        cnt++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
