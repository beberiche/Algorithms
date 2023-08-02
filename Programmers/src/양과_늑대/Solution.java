package 양과_늑대;

import java.util.*;
// 양과 늑대의 갯수를 업데이트
// 양과 늑대의 갯수과 변화되는 경우 이전 노드를 다시 탐색할 필요가 있음 => [노드][양][늑대] 의 3차원 방문처리
// 늑대가 양보다 많으면 return, 그렇지 않은 경우는 양의 최대 갯수를 업데이트
// 양이나 늑대를 또 추가하지 않도록 현재 노드도 방문처리
// 뒤늦게 추가되는 경우도 확인해야하므로 재귀 이후 노드 정보 및 방문처리 다시 초기화
class Solution {
    static List<Integer> list[];
    static int ans, visited[][][];

    public int solution(int[] info, int[][] edges) {
        list = new ArrayList[info.length];
        for(int i=0; i<info.length; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++) {
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        visited = new int[20][20][20];
        visited[0][0][0]=1;
        dfs(0,0,0,info);
        return ans;
    }

    private static void dfs(int n, int s, int w, int[] info) {
        int ns = s;
        int nw = w;

        if(info[n]==0) ns++;
        else if(info[n]==1) nw++;

        if(ns <= nw) return;
        ans = Math.max(ans, ns);

        int prev = info[n];
        info[n] = 9999;
        for(int next : list[n]) {
            if(visited[next][ns][nw] == 0) {
                visited[next][ns][nw]=1;
                dfs(next, ns, nw, info);
                visited[next][ns][nw]=0;
            }
        }
        info[n] = prev;
    }
}