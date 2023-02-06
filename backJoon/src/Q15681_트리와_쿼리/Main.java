package Q15681_트리와_쿼리;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Tree {
        int num;
        List<Tree> child = new ArrayList<>();

        Tree(int num) {
            this.num = num;
        }

        void push(Tree tree) {
            child.add(tree);
        }
    }

    static int N, R, Q;
    static Tree[] arr;
    static int[] childCnt,exp;
    static boolean[] visited;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        Q = Integer.parseInt(stk.nextToken());

        arr = new Tree[N + 1];
        childCnt = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new Tree(i);
        }


        for (int i = 0; i < N - 1; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            arr[n1].push(arr[n2]);
            arr[n2].push(arr[n1]);
        }

        exp = new int[Q]; // example
        for (int i = 0; i < Q; i++) {
            exp[i] = Integer.parseInt(br.readLine());
        }
    }

    private static int findChildCnt(Tree curr_tree) {
        visited[curr_tree.num] = true;

        int num = 1;
        for (Tree t : curr_tree.child) {
            if (visited[t.num]) continue;
            num += findChildCnt(t);
        }
        childCnt[curr_tree.num] = num;
        return num;

    }

    private static void output(int q) {
        for (int i = 0; i < q; i++) {
            System.out.println(childCnt[exp[i]]);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        findChildCnt(arr[R]);
        output(Q);
    }
}