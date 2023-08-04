package 퍼즐_조각_채우기;

import java.util.*;
class Solution {
    static HashMap<String, Integer> m = new HashMap<>();
    static int visited[][], dr[] = {0,0,1,-1}, dc[] = {1,-1,0,0}, ans;
    static Queue<int[]> q = new LinkedList<>();
    static List<int[]> list;

    private static void go(int r, int c, int row, int col, boolean isTable, int[][] arr) {
        visited[r][c]=1;
        q.add(new int[] {r,c});
        String str = "00";
        int cnt = 1;
        list = new ArrayList<>();
        list.add(new int[] {r,c});
        int CHECK = isTable ? 0:1;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int d=0; d<4; d++) {
                int nr = curr[0]+dr[d];
                int nc = curr[1]+dc[d];
                if(nr < 0 || nc < 0 || nr>=row || nc>=col) continue;
                if(arr[nr][nc]== CHECK || visited[nr][nc] > 0) continue;

                visited[nr][nc] = 1;
                q.add(new int[] {nr,nc});

                list.add(new int[] {nr,nc});
                str+=":"+((nr-r)+"")+((nc-c)+"");
                cnt++;
            }
        }


        if(isTable) {
            if(m.containsKey(str)) m.put(str, m.get(str)+1);
            else m.put(str, 1);
        } else {
            if(m.containsKey(str)) {
                m.put(str, m.get(str)-1);
                if(m.get(str)==0) m.remove(str);
                ans += cnt;
                for(int[] a : list) {
                    arr[a[0]][a[1]] = 2;
                    visited[a[0]][a[1]]=999;
                }
            }
        }
    }

    // 90도 방향 틀기
    private static int[][] rotate(int row, int col, int[][] board) {
        int[][] ret = new int[row][col];
        int[][] visited2 = new int[row][col];
        for(int i=0; i<row; i++) {
            for(int j=col-1; j>=0; j--) {
                ret[i][col-j-1] = board[j][i];
                if(visited[j][i] == 999) visited2[i][col-j-1] = 999;
                else visited2[i][col-j-1] = 0;
            }
        }
        visited= visited2;
        return ret;
    }
    public int solution(int[][] game_board, int[][] table) {
        visited = new int[table.length][table[0].length];
        for(int i=0; i<table.length; i++) {
            for(int j=0; j<table[0].length; j++) {
                if(table[i][j]>0 && visited[i][j]==0) {
                    go(i,j,table.length, table[0].length, true, table);
                }
            }
        }

        int idx=4;
        int row = game_board.length;
        int col = game_board[0].length;
        visited= new int[row][col];
        while(--idx>=0) {
            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    if(game_board[i][j]==0 && visited[i][j]==0) {
                        go(i,j,row,col, false, game_board);
                    }
                }
            }
            // 직사격형 일 경우를 대비한 row column 스왑
            int tmp = row;
            row = col;
            col = tmp;
            game_board = rotate(row,col,game_board);
        }

        return ans;
    }
}