package Q17135_캐슬_디펜스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 1. 조합을 통한 궁수 배치
// 2. 궁수를 시작점으로 바로 앞에, 적이 존재한다면 적을 저장하고 탐색 안함.
// 3. 그게 아닌 경우는, 궁수 +1 좌표를 시작으로, 왼쪽, 위, 오른쪽 순으로 탐색 BFS
// 4. 적을 찾은 경우 저장해뒀다가 3명의 궁수가 모두 한번의 탐색이 끝났을 때, 몰아서 처리
// 5. 중복해서 죽인 적은 카운트 하지 말 것
// 6. 적들 아래로 한칸씩 전진
// 7. 2~6 다시 반복. (현재 적군이 다 죽거나, 성을 넘어와서 맵에 존재하지 않으면 탐색 끝) -> 적 카운트 미리 세어두고 0이 되면 종료
// 8. 1~7 반복. 그중 최댓값 구하기.
public class Main {
    static int N, M, D, map[][], copyMap[][], cnt, copyCnt, KILL, ans;
    static boolean visited[][];
    static Queue<int[]> q;
    static int[] dr = {0, -1, 0};
    static int[] dc = {-1, 0, 1};

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        D = Integer.parseInt(stk.nextToken());

        map = new int[N][M];
        copyMap = new int[N + 1][M];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if (map[i][j] == 1) cnt++;
            }
        }
    }

    private static void copy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }

    private static int[] bfs(int r, int c) {
        if (copyMap[r - 1][c] == 1) {
            return new int[]{r - 1, c};
        }
        visited = new boolean[N][M];

        q = new LinkedList<>();
        q.add(new int[]{r - 1, c, 1});
        visited[r - 1][c] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[2] > D) continue;
            if (copyMap[curr[0]][curr[1]] == 1) {
                return new int[]{curr[0], curr[1]};
            }
            for (int d = 0; d < 3; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if (nr < 0 || nc < 0 || nc >= M || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc, curr[2] + 1});
            }
        }

        // 적 죽이지 못함
        return new int[]{-1, -1};
    }

    private static void kill(int[] pos) {
        if (pos[0] == -1 || copyMap[pos[0]][pos[1]] == 0) return;

        copyMap[pos[0]][pos[1]] = 0;
        copyCnt--;
        KILL++;
    }

    private static void moveEnemy() {
        // 적이 살아남고 성에 도달.
        for (int j = 0; j < M; j++) {
            if (copyMap[N - 1][j] == 1) copyCnt--;
        }

        // 적 이동
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                copyMap[i + 1][j] = copyMap[i][j];
            }
        }

        // 마지막 줄은 0으로 채우기
        for (int j = 0; j < M; j++) {
            copyMap[0][j] = 0;
        }
    }

    private static void solve() {
        // 궁수 조합
        for (int i = 0; i < M - 2; i++) {
            for (int j = i + 1; j < M - 1; j++) {
                for (int k = j + 1; k < M; k++) {
                    // 맵 카피
                    copy();
                    // 킬 시작.
                    KILL = 0;
                    // 궁수 배치 표시
                    copyCnt = cnt;
                    while (copyCnt != 0) {
                        int[] n1 = bfs(N, i);
                        int[] n2 = bfs(N, j);
                        int[] n3 = bfs(N, k);
                        kill(n1);
                        kill(n2);
                        kill(n3);
                        moveEnemy();
                    }
                    ans = Math.max(ans, KILL);
                }
            }
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
