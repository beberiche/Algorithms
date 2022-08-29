package Q15172_헌터;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int ans;
    static int move;
    static int[] currPos;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            ans = 987654321;
            // 몬스터 및 고객의 수
            int N = Integer.parseInt(br.readLine());

            List<int[]> monsters = new ArrayList<>();
            List<int[]> clients = new ArrayList<>();
            // 몬스터 양수
            // 고객 음수
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > 0) monsters.add(new int[]{map[i][j], i, j});
                    if (map[i][j] < 0) clients.add(new int[]{map[i][j], i, j});
                }
            }

            int[][] mix = new int[monsters.size() + clients.size()][3];
            int idxM = 0;
            int idxC = 0;
            for (int i = 0; i < mix.length; i++) {
                if (i < monsters.size()) {
                    mix[i][0] = monsters.get(idxM)[0];
                    mix[i][1] = monsters.get(idxM)[1];
                    mix[i][2] = monsters.get(idxM++)[2];
                } else if (i >= monsters.size()) {
                    mix[i][0] = clients.get(idxC)[0];
                    mix[i][1] = clients.get(idxC)[1];
                    mix[i][2] = clients.get(idxC++)[2];
                }
            }

            // 남은 거 순열
            int[][] sel = new int[mix.length][3];
            perm(0, sel, mix, new boolean[mix.length]);

            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    public static void perm(int cnt, int[][] sel, int[][] mix, boolean[] visited) {
        if (cnt >= mix.length) {
            // 순열 가운데 순서 거르기
            // 걸러야 하는 거 : 몬스터 잡기 전에 해당 클라이언트에게 찾아가려는 경우 (2번 찾아가야 하니 무조건 최소가 나올 수 없다)
            // sel[idx][0] 의 값은 각 몬스터와 클라이언트를 정보를 나타내는 대표(id)값이다.
            // 만약 현재 비교하는 값이 클라이언트 기준일 때,
            // 뒤 인덱스에 몬스터가 있는 값이 하나라도 존재한다면
            // 이 순열은 순서가 알맞지 않는 조합이다.
            boolean flag = true;
            outer:
            for (int i = 0; i < sel.length; i++) {
                int curr_client = sel[i][0];
                if (curr_client < 0) {
                    for (int j = i + 1; j < sel.length; j++) {
                        if (curr_client == sel[j][0] * -1) {
                            flag = false;
                            break outer;
                        }
                    }
                }
            }

            // 총 cnt 값 계산
            // 이동 값 누적하기
            if (flag) {
                int move = 0;
                int currR = 0;
                int currC = 0;

                for (int i = 0; i < sel.length; i++) {
                    // 좌표의 길이
                    move += Math.abs(currR - sel[i][1]) + Math.abs(currC - sel[i][2]);
                    // 현좌표 재설정
                    currR = sel[i][1];
                    currC = sel[i][2];
                }
                ans = Math.min(move, ans);
            }
            return;
        }

        for (int i = 0; i < mix.length; i++) {
            if (visited[i]) continue;
            sel[cnt][0] = mix[i][0];
            sel[cnt][1] = mix[i][1];
            sel[cnt][2] = mix[i][2];
            visited[i] = true;
            perm(cnt + 1, sel, mix, visited);
            visited[i] = false;
        }
    }
}
