package Q12318_기초_BFS_연습;

class UserSolution {
    private int[][] node;
    private boolean[][] visited;

    void bfs_init(int map_size, int map[][]) {
        node = new int[map_size][map_size];
        for (int i = 0; i < map_size; i++)
            for (int j = 0; j < map_size; j++) node[i][j] = map[i][j];
    }

    int bfs(int x1, int y1, int x2, int y2) {
        int[][] q = new int[node.length * node.length][3];
        int front = -1, rear = -1;
        int[] dr = {-1, 0, 1, 0}, dc = {0, -1, 0, 1};
        q[++rear] = new int[]{y1 - 1, x1 - 1, 0};
        visited = new boolean[node.length][node.length];
        visited[q[rear][0]][q[rear][1]] = true;
        while (front != rear) {
            int[] curr = q[++front];
            if (curr[0] == y2 - 1 && curr[1] == x2 - 1) return curr[2];
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if (nr < 0 || nc < 0 || nr >= node.length || nc >= node.length || visited[nr][nc] || node[nr][nc] == 1)
                    continue;
                visited[nr][nc] = true;
                q[++rear] = new int[]{nr, nc, curr[2] + 1};
            }
        }
        return -1;
    }
}

