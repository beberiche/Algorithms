package Q3190_뱀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, L;
    static int[][] map;
    static StringTokenizer stk;
    static final int[] dr = new int[]{0, 1, 0, -1};
    static final int[] dc = new int[]{1, 0, -1, 0};

    static class Snake {
        int t;
        char dir;

        public Snake(int t, char dir) {
            this.t = t;
            this.dir = dir;
        }
    }

    static Queue<Snake> q = new LinkedList<>();
    static ArrayList<Integer> headDirHistory = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < K; i++) {
            stk = new StringTokenizer(br.readLine());
            map[Integer.parseInt(stk.nextToken()) - 1][Integer.parseInt(stk.nextToken()) - 1] = 2;
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            stk = new StringTokenizer(br.readLine());
            q.add(new Snake(Integer.parseInt(stk.nextToken()), stk.nextToken().charAt(0)));
        }


        int[] posH = new int[]{0, 0};
        int[] posT = new int[]{0, 0};
        // 뱀의 머리 방향과 꼬리 방향
        int[] currHTDir = new int[]{0, 0};
        int len = 1;
        map[0][0] = 1;
        int currT = 1;

        while (true) {
            headDirHistory.add(currHTDir[0]);
            currHTDir[1] = headDirHistory.get(currT - len);

            // 다음 머리 좌표
            int nhr = posH[0] + dr[currHTDir[0]];
            int nhc = posH[1] + dc[currHTDir[0]];

            if (nhr < 0 || nhc < 0 || nhr >= N || nhc >= N || map[nhr][nhc] == 1) {
                System.out.println(currT);
                return;
            }

            boolean isApple = false;
            if (map[nhr][nhc] == 2) isApple = true;

            posH[0] = nhr;
            posH[1] = nhc;
            map[posH[0]][posH[1]] = 1;

            if (isApple) len++;
            else {
                int ntr = posT[0] + dr[currHTDir[1]];
                int ntc = posT[1] + dc[currHTDir[1]];
                map[posT[0]][posT[1]] = 0;
                posT[0] = ntr;
                posT[1] = ntc;
            }

            if (!q.isEmpty() && q.peek().t == currT) {
                if (q.peek().dir == 'D') currHTDir[0] = (currHTDir[0] + 1) % 4;
                else currHTDir[0] = (currHTDir[0] + 3) % 4;
                q.poll();
            }
            currT++;
        }
    }
}
