package Q2224_명제_증명;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    private static List<Integer> list[];
    private static boolean[] visited;
    private static TreeSet<String> s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[123];


        for (int i = 1; i <= N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n1 = (int) stk.nextToken().charAt(0);
            stk.nextToken();
            int n2 = (int) stk.nextToken().charAt(0);
            if (n1 == n2) continue;

            if (list[n1] == null) list[n1] = new ArrayList<>();

            list[n1].add(n2);
        }

        s = new TreeSet<>();
        for (int i = 1; i < list.length; i++) {
            if (list[i] != null) {
                visited = new boolean[list.length];
                visited[i] = true;
                go(i, i);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.size()).append("\n");
        for(String str : s) {
            sb.append(str).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void go(int root, int curr) {
        if(list[curr] == null) return;

        for (int next : list[curr]) {
            if(visited[next]) continue;
            visited[next] = true;
            s.add((char) root + " => " + (char) next);
            go(root, next);
        }
    }
}
