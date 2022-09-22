package Q16562_친구비;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[][] edges = new int[M][2];
        int[][] cost = new int[N][2];
        boolean[] check= new boolean[N];
        p = new int[N];
        for(int i=0; i<N; i++) {
            p[i] =i;
        }

        for(int i=0; i<N; i++) {
          cost[i][0] = i;
          cost[i][1] = sc.nextInt();
        }

        for(int i=0; i<M; i++) {
            int st = sc.nextInt()-1;
            int ed = sc.nextInt()-1;
            union(st,ed);
        }

        Arrays.sort(cost, (o1,o2)-> o1[1]-o2[1]);

        int total = K;
        for(int i=0; i<N; i++) {
            int curr = find(cost[i][0]);
            if(check[curr]) continue;
            check[curr] = true;
            total -= cost[i][1];
            if(total<0) {
                System.out.println("Oh no");
                System.exit(0);
            }
        }
        System.out.println(K-total);
    }

    public static int find(int x) {
        if(x==p[x]) return x;
        return p[x] = find(p[x]);
    }

    public static void union(int x ,int y) {
        p[find(y)] = find(x);
    }
}
