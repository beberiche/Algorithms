package Q15681_트리와_쿼리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tree {
    int node;
    List<Integer> child;

    public Tree(int node) {
        this.node = node;
        this.child = new ArrayList<>();
    }

}

public class Main {
    static Tree[] map;
    static int ans;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();
        int Q = sc.nextInt();
        map = new Tree[N + 1];

        for (int i = 1; i <= N; i++)
            map[i] = new Tree(i);

        for (int i = 1; i <= N - 1; i++) {
            int p = sc.nextInt();
            int c = sc.nextInt();
            map[p].child.add(c);
            map[c].child.add(p);
        }

        StringBuffer sb = new StringBuffer();
        while (--Q >= 0) {
            ans = 0;
            visited = new boolean[N + 1];
            countChild(map[R], sc.nextInt(), false);
            sb.append(ans +" \n");
        }
        System.out.println(sb.toString());
    }

    public static void countChild(Tree tree, int currNode, boolean check) {
        if (visited[tree.node]) return;
        visited[tree.node] = true;
        if (tree.node == currNode || check) ans++;
        for (int c : tree.child) {
            if (tree.node == currNode || check) countChild(map[c], currNode, true);
            else countChild(map[c], currNode, false);
        }
    }
}