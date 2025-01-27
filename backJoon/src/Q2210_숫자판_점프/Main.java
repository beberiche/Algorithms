package Q2210_숫자판_점프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static Set<String> s;
    private static int[][] a;
    private static int[] dr, dc;
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 5;

        a = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        s = new HashSet<>();
        dr = new int[]{-1, 0, 1, 0};
        dc = new int[]{0, -1, 0, 1};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                go(i, j);
            }
        }

        System.out.println(s.size());
    }

    private static void go(int r, int c) {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(r, c, ""));
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.sb.length() >= 6) {
                s.add(curr.sb.toString());
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                q.add(new Node(nr, nc, curr.sb.toString()));
            }
        }
    }

    private static class Node {
        int r;
        int c;
        StringBuilder sb;

        Node(int r, int c, String str) {
            this.r = r;
            this.c = c;
            sb = new StringBuilder(str);
            sb.append(a[r][c]);
        }
    }
}
