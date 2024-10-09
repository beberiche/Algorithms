package Q9177_단어_섞기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int order = 1;
        while (--T >= 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String a = stk.nextToken();
            String b = stk.nextToken();
            String c = stk.nextToken();

            sb.append("Data set ").append(order++).append(": ").append(go(a, b, c) ? "yes" : "no").append("\n");
        }
        System.out.print(sb.toString());
    }

    private static boolean go(String a, String b, String c) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[a.length()+1][b.length()+1];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[2] >= c.length()) {
                return true;
            }

            if (curr[0] < a.length() && a.charAt(curr[0]) == c.charAt(curr[2]) && !visited[curr[0] + 1][curr[1]]) {
                visited[curr[0] + 1][curr[1]] = true;
                q.add(new int[]{curr[0] + 1, curr[1], curr[2] + 1});
            }

            if (curr[1] < b.length() && b.charAt(curr[1]) == c.charAt(curr[2]) && !visited[curr[0]][curr[1] + 1]) {
                visited[curr[0]][curr[1] + 1] = true;
                q.add(new int[]{curr[0], curr[1] + 1, curr[2] + 1});
            }
        }

        return false;
    }
}
