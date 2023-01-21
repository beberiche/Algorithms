package Q11559_Puyo_Puyo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static List<int[]> list;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        list = new ArrayList<>();
        while(true) {
            visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        visited[i][j] = true;
                        BFS(i, j);
                    }
                }
            }
            if(list.size() <= 0) break;
            else {
                ans++;
                for(int[] pos : list) map[pos[0]][pos[1]] = '.';
                outer :for(int c=0; c<6; c++) {
                    for(int r=11; r>=0; r--) {
                        if (map[r][c] == '.') {
                            int step = 1;
                            for (int k = r-1; k >= 0; k--) {
                                if (map[k][c] == '.') step++;
                                else {
                                    map[k + step][c] = map[k][c];
                                    map[k][c] = '.';
                                }
                            }
                            continue outer;
                        }
                    }
                }
                list = new ArrayList<>();
            }
        }
        System.out.println(ans);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> tList = new ArrayList<>();
        q.add(new int[]{i, j});
        tList.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] +dr[d];
                int nc = curr[1] +dc[d];
                if(nr<0 || nc<0 || nr>=12 || nc>=6 || visited[nr][nc] || map[i][j] != map[nr][nc]) continue;

                visited[nr][nc] = true;
                q.add(new int[] {nr,nc});
                tList.add(new int[] {nr,nc});
            }
        }

        if(tList.size() >= 4) {
            for(int[] pos : tList) list.add(pos);
        }
    }
}
