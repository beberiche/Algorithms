package Q20040_사이클_게임;

import java.util.Scanner;


public class Main {
    static int[] p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] edges = new int[M][2];

        for(int i=0; i<M; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        p = new int[N];
        for(int i=0; i<N; i++) {
            p[i] = i;
        }

        int ans = 0;
        int cnt = 0;
        for(int i=0; i<M; i++) {
            int px = find(edges[i][0]);
            int py = find(edges[i][1]);

            if(px!= py) {
                union(px,py);
                cnt++;
            } else {
                ans = ++cnt;
                break;
            }
        }
        System.out.println(ans);
    }

    static int find(int x) {
        if(x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    static void union(int x, int y) {
        p[find(y)] = find(x);
    }
}
