package Q15653_구슬_탈출_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    class Marble {
        int dir, step;
        int[] red, blue;
        boolean isOutRed, isOutBlue;
        char[][] map;

        public Marble(int dir, int step, int[] red, int[] blue, char[][] map) {
            this.dir = dir;
            this.step = step;
            this.red = red;
            this.blue = blue;
            this.map = map;
        }
    }

    int N, M, red[], blue[];
    // 홀수 -> 좌우
    // 짝수 -> 상하
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};
    char map[][];

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'R') {
                    red = new int[]{i, j};
                }
                if (map[i][j] == 'B') {
                    blue = new int[]{i, j};
                }
            }
        }
    }


    private char[][] copyMap(char[][] map) {
        char[][] copy = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    private void swap(char[][] map, int[] from, int[] to) {
        char tmp = map[from[0]][from[1]];
        map[from[0]][from[1]] = map[to[0]][to[1]];
        map[to[0]][to[1]] = tmp;
    }

    private void go(Marble curr) {
        char map[][] = curr.map;
        int[] red = curr.red;
        int[] blue = curr.blue;
        int dir = curr.dir;

        int check = 0;

        if (dir == 0 && red[0] > blue[0]) check = 1;
        else if (dir == 1 && red[1] > blue[1]) check = 1;
        else if (dir == 2 && red[0] < blue[0]) check = 1;
        else if (dir == 3 && red[1] < blue[1]) check = 1;

        int[] pos1, pos2;
        if (check == 0) {
            pos1 = curr.red;
            pos2 = curr.blue;
        } else {
            pos1 = curr.blue;
            pos2 = curr.red;
        }

        int[] next1 = new int[]{pos1[0], pos1[1]};
        while (true) {
            int nr = next1[0] + dr[dir];
            int nc = next1[1] + dc[dir];


            if (nr < 0 || nc < 0 || nr >= N || nc >= M) break;

            if (map[nr][nc] != '.') {
                if (map[nr][nc] == 'O') {
                    if (check == 0) {
                        curr.isOutRed = true;
                    } else curr.isOutBlue = true;
                }
                break;
            }

            next1[0] = nr;
            next1[1] = nc;
        }

        swap(map, pos1, next1);
        if (check == 0) {
            curr.red = new int[]{next1[0], next1[1]};
            if (curr.isOutRed) map[next1[0]][next1[1]] = '.';
        } else curr.blue = new int[]{next1[0], next1[1]};


        int[] next2 = new int[]{pos2[0], pos2[1]};
        while (true) {
            int nr = next2[0] + dr[dir];
            int nc = next2[1] + dc[dir];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;


            if (map[nr][nc] != '.') {
                if (map[nr][nc] == 'O') {
                    if (check == 0) curr.isOutBlue = true;
                    else curr.isOutRed = true;
                }
                break;
            }

            next2[0] = nr;
            next2[1] = nc;
        }
        swap(map, pos2, next2);
        if (check == 1) curr.red = new int[]{next2[0], next2[1]};
        else curr.blue = new int[]{next2[0], next2[1]};


//        return curr;
    }

    private int solve() {
        Queue<Marble> q = new LinkedList<>();
        boolean visited[][][][] = new boolean[N][M][N][M];
        q.add(new Marble(0, 1, new int[]{red[0], red[1]}, new int[]{blue[0], blue[1]}, copyMap(map)));
        q.add(new Marble(1, 1, new int[]{red[0], red[1]}, new int[]{blue[0], blue[1]}, copyMap(map)));
        q.add(new Marble(2, 1, new int[]{red[0], red[1]}, new int[]{blue[0], blue[1]}, copyMap(map)));
        q.add(new Marble(3, 1, new int[]{red[0], red[1]}, new int[]{blue[0], blue[1]}, copyMap(map)));

        visited[red[0]][red[1]][blue[0]][blue[1]] = true;

        while (!q.isEmpty()) {
            Marble curr = q.poll();


            go(curr);
            if (curr.isOutBlue) {
                continue;
            } else if (curr.isOutRed) {
                return curr.step;
            } else {
                int dir = curr.dir;
                int step = curr.step;
                int[] red = curr.red;
                int[] blue = curr.blue;
                char[][] map = curr.map;
                if (dir % 2 == 0) {
                    if(!visited[red[0]][red[1]][blue[0]][blue[1]]) {
                        visited[red[0]][red[1]][blue[0]][blue[1]] = true;
                        q.add(new Marble(1, step + 1, new int[]{red[0], red[1]}, new int[]{blue[0], blue[1]}, copyMap(map)));
                        q.add(new Marble(3, step + 1, new int[]{red[0], red[1]}, new int[]{blue[0], blue[1]}, copyMap(map)));
                    }
                } else {
                    if(!visited[red[0]][red[1]][blue[0]][blue[1]]) {
                        visited[red[0]][red[1]][blue[0]][blue[1]] = true;
                        q.add(new Marble(0, step + 1, new int[]{red[0], red[1]}, new int[]{blue[0], blue[1]}, copyMap(map)));
                        q.add(new Marble(2, step + 1, new int[]{red[0], red[1]}, new int[]{blue[0], blue[1]}, copyMap(map)));
                    }
                }
            }
        }

        return -1;
    }

    private static void output(int ret) {
        System.out.println(ret);
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.output(m.solve());
    }
}

