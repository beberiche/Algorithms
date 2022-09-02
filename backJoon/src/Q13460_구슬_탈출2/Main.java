package Q13460_구슬_탈출2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Biz {
    int r;
    int c;
    int cnt;

    Biz(int r, int c, int cnt) {
        this.r = r;
        this.c= c;
        this.cnt = cnt;
    }
}


public class Main {
    static int N,M;
    static char[][] map;
    static boolean[][][][] visited;
    static final int[] DR = {0,1,0,-1};
    static final int[] DC = {1,0,-1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M];
        Biz red = null;
        Biz blue = null;
        for(int i=0; i<N; i++) {
            String temp = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = temp.charAt(j);
                if(map[i][j]=='R') {
                    red = new Biz(i,j,0);
                    map[i][j] = '.';
                }
                else if (map[i][j] == 'B') {
                    blue = new Biz(i,j,0);
                    map[i][j] = '.';
                }
            }
        }
        System.out.println(BFS(red, blue));
    }

    static int BFS(Biz red, Biz blue) {
        Queue<Biz> rq = new LinkedList<>();
        Queue<Biz> bq = new LinkedList<>();
        rq.add(red);
        bq.add(blue);

        while(!rq.isEmpty() && !bq.isEmpty()) {
            Biz curR = rq.poll();
            Biz curB = bq.poll();
            if(curR.cnt+1 > 10) return -1;
            for(int d=0; d<4; d++) {
                int rr = curR.r;
                int rc = curR.c;
                int br = curB.r;
                int bc = curB.c;
                boolean confRedCheck = false;
                boolean blueOutCheck = false;
                visited[rr][rc][br][bc] = true;
                while(true) {
                    br+= DR[d];
                    bc+= DC[d];
                    if(rr == br && rc == bc) {
                        confRedCheck = true;
                        break;
                    }
                    if(map[br][bc]=='#') {
                        br -= DR[d];
                        bc -= DC[d];
                        break;
                    }
                    if(map[br][bc]=='O') {
                        blueOutCheck = true;
                        break;
                    }
                }
                while(!blueOutCheck) {
                    rr+=DR[d];
                    rc+=DC[d];
                    if(rr == br && rc == bc) {
                        if(!visited[rr-DR[d]][rc-DC[d]][br][bc]) {
                            rq.add(new Biz(rr-DR[d], rc-DC[d], curR.cnt+1));
                            bq.add(new Biz(br,bc,curB.cnt+1));;
                        }
                        break;
                    }
                    if(map[rr][rc]=='#') {
                        if(!visited[rr-DR[d]][rc-DC[d]][br][bc]) {
                            rq.add(new Biz(rr - DR[d], rc - DC[d], curR.cnt + 1));
                            if (confRedCheck) bq.add(new Biz(rr - DR[d] * 2, rc - DC[d] * 2, curR.cnt + 1));
                            else bq.add(new Biz(br, bc, curB.cnt + 1));
                        }
                        break;
                    }
                    if (map[rr][rc] == 'O') {
                        if(blueOutCheck || confRedCheck) break;
                        return curR.cnt +1;
                    }
                }
            }
        }
        System.out.println("end");
        return -1;
    }
}
