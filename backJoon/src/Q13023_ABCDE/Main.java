package Q13023_ABCDE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> adjList[];
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            adjList[n1].add(n2);
            adjList[n2].add(n1);
        }

        for (int i = 0; i < N; i++) {
            ans = 1;
            visited = new boolean[N];
            DFS(i, ans);
            if(ans >= 5) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
        br.close();
    }

    private static void DFS(int idx, int cnt) {
        if(visited[idx]) return;
        if(cnt >= 5 || ans >= 5) {
            ans = 5;
            return;
        }

        visited[idx] = true;
        for(Integer nNode : adjList[idx]) DFS(nNode, cnt+1);
        visited[idx] = false;
    }
}