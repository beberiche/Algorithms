package Q2151_거울_설치;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 3차원 방문처리
// ! 에서 /,\, 설치 안한 경우를 모두 처리.
// . 이면 기존 방향으로 계속 진행
public class Main {
    static int N, door1[], door2[], ans;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, -1, 0, 1};
    static char map[][];
    static boolean visited[][][];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '#' && door1 == null) {
                    door1 = new int[]{i, j};
                } else if (map[i][j] == '#') {
                    door2 = new int[]{i, j};
                }
            }
        }
    }

    private static void solve() {
        PriorityQueue<int[]> q = new PriorityQueue<>((n1, n2) -> n1[2] - n2[2]);
        visited = new boolean[N][N][4];

        for (int d = 0; d < 4; d++) {
            q.add(new int[]{door1[0], door1[1], 0, d});
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            visited[curr[0]][curr[1]][curr[3]] = true;

            if (curr[0] == door2[0] && curr[1] == door2[1]) {
                ans = curr[2];
                break;
            }

            int nr = curr[0] + dr[curr[3]];
            int nc = curr[1] + dc[curr[3]];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc][curr[3]] || map[nr][nc] == '*') continue;

            if (map[nr][nc] == '!') {
                int nd = (curr[3] + 3) % 4;
                q.add(new int[]{nr, nc, curr[2] + 1, nd});

                nd = (curr[3] + 1) % 4;
                q.add(new int[]{nr, nc, curr[2] + 1, nd});
            }


            q.add(new int[]{nr, nc, curr[2], curr[3]});
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
