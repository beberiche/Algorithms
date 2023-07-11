package Q17406_배열_돌리기_4;

import java.util.*;
import java.io.*;

// 순열만들기
// 현재 배열 카피
// 오른쪽으로 이동시키는 함수
//  r1,r2,c1,c2 지정
//  r1 : r의 시작점, c1 : c의 시작점, r2 : r의 끝점, c2: c의 끝점
//  r1,c1은 +1씩 증가 r2,c2는 -1씩 감소
//  4번의 좌표 누적을 통한 이동
// 행별 누적 확인 함수
public class Main {
    static int N, M, K, a[][], visited[], tmp[], ans = Integer.MAX_VALUE;
    static List<int[]> list;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        a = new int[N + 1][M + 1];
        tmp = new int[K];
        visited = new int[K];
        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            int n3 = Integer.parseInt(stk.nextToken());
            list.add(new int[]{n1, n2, n3});
        }
    }

    private static int[][] copy() {
        int[][] copy = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                copy[i][j] = a[i][j];
            }
        }
        return copy;
    }

    private static int count(int[][] arr) {
        int cnt = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int ret = 0;
            for (int j = 1; j <= M; j++) {
                ret += arr[i][j];
            }
            cnt = Math.min(cnt, ret);
        }
        return cnt;
    }

    private static void move() {
        int[][] copy_a = copy();
        for (int i = 0; i < K; i++) {
            int[] curr = list.get(tmp[i]);
            int r1 = curr[0] - curr[2];
            int c1 = curr[1] - curr[2];
            int r2 = curr[0] + curr[2];
            int c2 = curr[1] + curr[2];

            for (int k = 0; k < curr[2]; k++) {
                int prev1 = copy_a[r1][c1];
                int prev2 = copy_a[r1][c2];
                int prev3 = copy_a[r2][c1];
                int prev4 = copy_a[r2][c2];


                for (int j = c2; j >= c1 + 2; j--) {
                    copy_a[r1][j] = copy_a[r1][j - 1];
                }
                copy_a[r1][c1 + 1] = prev1;

                for (int j = r2; j >= r1 + 2; j--) {
                    copy_a[j][c2] = copy_a[j - 1][c2];
                }
                copy_a[r1 + 1][c2] = prev2;


                for (int j = c1; j <= c2 - 2; j++) {
                    copy_a[r2][j] = copy_a[r2][j + 1];
                }
                copy_a[r2][c2 - 1] = prev4;

                for (int j = r1; j <= r2 - 2; j++) {
                    copy_a[j][c1] = copy_a[j + 1][c1];
                }
                copy_a[r2 - 1][c1] = prev3;

                r1++;
                c1++;
                r2--;
                c2--;
            }
        }

        ans = Math.min(count(copy_a), ans);
    }


    private static void solve(int cnt) {
        if (cnt >= K) {
            move();
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (visited[i] > 0) continue;
            visited[i]++;
            tmp[cnt] = i;
            solve(cnt + 1);
            visited[i]--;
        }
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve(0);
        output();
    }
}
