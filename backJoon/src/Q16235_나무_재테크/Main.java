package Q16235_나무_재테크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    class Land {
        // nutriment
        int n;
        PriorityQueue<Tree> t;

        Land(int n) {
            this.n = n;
            t = new PriorityQueue<>((t1, t2) -> t1.age - t2.age);
        }
    }

    class Tree {
        int r, c;
        int age;

        Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }
    }

    int N, M, K, a[][];
    Land l[][];
    List<Tree> live = new ArrayList<>();
    List<Tree> breed = new ArrayList<>();
    List<Tree> death = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }

    private void solve() {
        for (int k = 0; k < K; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (l[i][j].t.size() > 0) {
                        spring(i, j);
                        summer(i, j);
                    }
                }
            }
            autumn();
            winter();
            breed.clear();
        }
    }

    private void output() {
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                ans += l[i][j].t.size();
            }
        }
        System.out.println(ans);
    }


    private void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                l[i][j].n += a[i][j];
            }
        }
    }


    private void autumn() {
        for (int i = 0; i < breed.size(); i++) {
            Tree tree = breed.get(i);
            int r = tree.r;
            int c = tree.c;
            int ur = r - 1, dr = r + 1, lc = c - 1, rc = c + 1;

            // 위
            if (ur > 0) l[ur][c].t.add(new Tree(ur, c, 1));
            // 아래
            if (dr <= N) l[dr][c].t.add(new Tree(dr, c, 1));
            // 왼쪽
            if (lc > 0) l[r][lc].t.add(new Tree(r, lc, 1));
            // 오른쪽
            if (rc <= N) l[r][rc].t.add(new Tree(r, rc, 1));
            // 대각선 위 왼쪽
            if (ur > 0 && lc > 0) l[ur][lc].t.add(new Tree(ur, lc, 1));
            // 대각선 위 오른쪽
            if (ur > 0 && rc <= N) l[ur][rc].t.add(new Tree(ur, rc, 1));
            // 대각선 아래 왼쪽
            if (dr <= N && lc > 0) l[dr][lc].t.add(new Tree(dr, lc, 1));
            // 대각선 아래 오른쪽
            if (dr <= N && rc <= N) l[dr][rc].t.add(new Tree(dr, rc, 1));
        }
        breed.clear();
    }

    private void summer(int r, int c) {
        int ret = 0;
        for (int i = 0; i < death.size(); i++) {
            ret += death.get(i).age / 2;
        }
        l[r][c].n += ret;
        death.clear();
    }

    private void spring(int r, int c) {
        PriorityQueue<Tree> pq = l[r][c].t;
        int cnt = pq.size();
        for (int i = 0; i < cnt; i++) {
            Tree tree = l[r][c].t.poll();
            if (tree.age <= l[r][c].n) {
                l[r][c].n -= tree.age;
                tree.age++;
                if (tree.age % 5 == 0) breed.add(tree);
                live.add(tree);
            } else {
                death.add(tree);
            }
        }

        for (int i = 0; i < live.size(); i++) {
            pq.add(live.get(i));
        }
        live.clear();
    }


    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        a = new int[N + 1][N + 1];
        l = new Land[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
                l[i][j] = new Land(5);
            }
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            int age = Integer.parseInt(stk.nextToken());
            l[n1][n2].t.add(new Tree(n1, n2, age));
        }
    }
}
