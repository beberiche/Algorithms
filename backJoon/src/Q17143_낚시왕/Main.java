package Q17143_낚시왕;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 사람이동
// 상어잡기
// 상어이동
// 상어잡아먹기
// 한 칸씩 움직이면 시간초과 나올듯, 시작과 결과를 한번에 나타내는 계산 필요.
public class Main {
    static class Shark {
        int r, c, s, d, z;
        boolean killed;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
            this.killed = false;
        }
    }

    static int dr[] = {-1, 1, 0, 0}, dc[] = {0, 0, 1, -1};
    static int map[][], tmp[][], R, C, M, ans;
    static Shark shark[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        shark = new Shark[M + 1];
        map = new int[R][C];
        int r, c, s, d, z;
        for (int i = 1; i <= M; i++) {
            stk = new StringTokenizer(br.readLine());
            r = Integer.parseInt(stk.nextToken()) - 1;
            c = Integer.parseInt(stk.nextToken()) - 1;
            s = Integer.parseInt(stk.nextToken());
            d = Integer.parseInt(stk.nextToken()) - 1;
            z = Integer.parseInt(stk.nextToken());
            shark[i] = new Shark(r, c, s, d, z);

            if (d <= 1) shark[i].s %= (2 * (R - 1));
            else shark[i].s %= (2 * (C - 1));

            map[r][c] = i;
        }
    }

    private static void mapcopy() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                map[r][c] = tmp[r][c];
            }
        }
    }

    private static void sharkPosCheck(int idx) {
        if (tmp[shark[idx].r][shark[idx].c] == 0) tmp[shark[idx].r][shark[idx].c] = idx;
        else {
            int currIdx = tmp[shark[idx].r][shark[idx].c];
            if (shark[currIdx].z < shark[idx].z) {
                shark[currIdx].killed = true;
                tmp[shark[idx].r][shark[idx].c] = idx;
            } else {
                shark[idx].killed = true;
            }
        }
    }

    private static int[] sharkMove(Shark shark) {
        int curr_r = shark.r;
        int curr_c = shark.c;
        int curr_s = shark.s;
        int curr_d = shark.d;

        int nr, nc;
        // 상어이동
        while (true) {
            nr = curr_r + curr_s * dr[curr_d];
            nc = curr_c + curr_s * dc[curr_d];

            if (nr < R && nc < C && nr >= 0 && nc >= 0) break;
            if (nr < 0) {
                curr_s -= curr_r;
                curr_r = 0;
                curr_d = 1;
            } else if (nr >= R) {
                curr_s -= R - 1 - curr_r;
                curr_r = R - 1;
                curr_d = 0;
            } else if (nc < 0) {
                curr_s -= curr_c;
                curr_c = 0;
                curr_d = 2;
            } else if (nc >= C) {
                curr_s -= C - 1 - curr_c;
                curr_c = C - 1;
                curr_d = 3;
            }
        }
        return new int[]{nr, nc, curr_d};
    }

    private static void sharkCatch(int idx) {
        for (int j = 0; j < R; j++) {
            if (map[j][idx] > 0) {
                shark[map[j][idx]].killed = true;
                ans += shark[map[j][idx]].z;
                map[j][idx] = 0;
                break;
            }
        }
    }


    private static void solve() {
        // 사람이동
        for (int i = 0; i < C; i++) {
            // 상어잡기
            sharkCatch(i);

            tmp = new int[R][C];
            for (int j = 1; j <= M; j++) {
                if (shark[j].killed) continue;

                // nr,nc,dir
                int[] pos = sharkMove(shark[j]);

                shark[j].r = pos[0];
                shark[j].c = pos[1];
                shark[j].d = pos[2];
                // 움직인 좌표가 겹치는 상어가 있다면 큰게 작은 거 잡아먹기!
                sharkPosCheck(j);
            }

            // 최종 결과 업데이트
            mapcopy();
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