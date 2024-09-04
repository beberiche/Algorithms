package Q5176_대회_자리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        while (--K >= 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());

            boolean[] visited = new boolean[M + 1];
            int cnt = 0;

            for (int i = 0; i < P; i++) {
                int now = Integer.parseInt(br.readLine());

                if (visited[now]) cnt++;
                else visited[now] = true;
            }

            sb.append(cnt).append("\n");
        }
        System.out.print(sb.toString());
    }
}
