package 카카오프렌즈컬러링북;

import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        int[][] map = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] = picture[i][j];
            }
        }
        
        final int[] dr = {1,0,-1,0};
        final int[] dc = {0,1,0,-1};
       
        for(int i=0; i<m;i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    Queue<int[]> q = new LinkedList<>();
                    visited[i][j] = true;
                    q.add(new int[] {i,j, map[i][j]});
                    int currLen=1;
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        for(int d=0;d<4;d++) {
                            int nr = curr[0] + dr[d];
                            int nc = curr[1] + dc[d];
                            
                            if(nr<0 || nc<0 || nr>=m || nc>=n)
                                continue;
                            
                            if(curr[2]!=map[nr][nc])
                                continue;
                            
                            if(visited[nr][nc])
                                continue;
                            
                            visited[nr][nc] = true;
                            q.add(new int[] {nr, nc, curr[2]});
                            currLen++;
                        }
                    }
                    maxSizeOfOneArea = Math.max(currLen, maxSizeOfOneArea); 
                }
            }               
        }
        

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}