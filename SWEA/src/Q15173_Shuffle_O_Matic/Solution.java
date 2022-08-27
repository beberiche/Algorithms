package Q15173_Shuffle_O_Matic;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int N;
    static int ans;
    static int half;

    static int cnt = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t=1; t<=T;t++) {
            N = sc.nextInt();
            half = N/2;
            int[] card = new int[N];
            for(int i=0; i<N; i++) card[i] = sc.nextInt();

            ans = 6;
            cnt = 0;

            recur(0, 0, card);

            System.out.printf("#%d %d\n",t, ans<=5 ? ans : -1);
        }

    }
    public static void recur(int depth, int idx, int[] card) {
        if (depth >= 6 || depth >= ans || cnt >= N*50000) return;
        else {
            boolean isAsc = card[0] < card[1];
            boolean flag = true;
            for(int i=1; i<N; i++) {
                if(isAsc && card[i-1] > card[i]) {
                    flag = false;
                    break;
                } else if(!isAsc && card[i-1]<card[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                ans = depth;
                return;
            }
        }

        for (int x = 0; x < N; x++) {
            if (half- x > 0) {
                // 점점 증가
                // shuffle 할 카드 준비
                int[][] tempIdx = new int[x + 1][2];
                int st = - x - 2;
                for (int d = 0; d < tempIdx.length; d++) {
                    tempIdx[d][0] = half + (st += 1);
                    tempIdx[d][1] = half + (st += 1);
                }
                // shuffle!
                for (int d = 0; d < tempIdx.length; d++) {
                    int temp = card[tempIdx[d][0]];
                    card[tempIdx[d][0]] = card[tempIdx[d][1]];
                    card[tempIdx[d][1]] = temp;
                }
            } else {
                // 점점 감소
                int[][] tempIdx = new int[N - x - 1][2];
                int st = x - N;
                for (int d = 0; d < tempIdx.length; d++) {
                    tempIdx[d][0] = half + (st += 1);
                    tempIdx[d][1] = half + (st += 1);
                }
                for (int d = 0; d < tempIdx.length; d++) {
                    int temp = card[tempIdx[d][0]];
                    card[tempIdx[d][0]] = card[tempIdx[d][1]];
                    card[tempIdx[d][1]] = temp;
                }
            }
            cnt++;
            recur(depth + 1, x, Arrays.copyOf(card, card.length));
        }
    }
}
