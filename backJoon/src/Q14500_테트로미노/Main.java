package Q14500_테트로미노;

import java.util.Scanner;

public class Main {
    // 정사각형
    static int[][] tr1 = {{0,1},{1,0},{1,1}};
    // 막대기
    static int[][] tr2Row = {{0,1},{0,2},{0,3}};
    static int[][] tr2Col = {{1,0},{2,0},{3,0}};
    // 번개모양?
    static int[][] tr3Row = {{0,1},{-1,1},{-1,2}};
    static int[][] tr3Col = {{1,0},{1,1},{2,1}};
    static int[][] tr3RowRev = {{0,1},{1,1},{1,2}};
    static int[][] tr3ColRev ={{1,0},{1,-1},{2,-1}};
    // 기역
    static int[][] tr4Ang0 = {{1,0},{2,0},{2,1}};
    static int[][] tr4Ang90 = {{1,0},{0,1},{0,2}};
    static int[][] tr4Ang180 = {{0,1},{1,1},{2,1}};
    static int[][] tr4Ang270 = {{1,0},{1,-1},{1,-2}};
    static int[][] tr4Ang0Rev = {{1,0},{2,0},{2,-1}};
    static int[][] tr4Ang90Rev = {{0,1},{0,2},{1,2}};
    static int[][] tr4Ang180Rev = {{0,1},{1,0},{2,0}};
    static int[][] tr4Ang270Rev = {{1,0},{1,1},{1,2}};
    // 성?
    static int[][] tr5Ang0 = {{0,1},{0,2},{1,1}};
    static int[][] tr5Ang90 = {{1,0},{2,0},{1,-1}};
    static int[][] tr5Ang180 = {{1,-1},{1,0},{1,1}};
    static int[][] tr5Ang270 = {{1,0},{2,0},{1,1}};

    static int[][] map;
    static int N,M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        System.out.println(findMaxSum());
    }
    private static int findMaxSum() {
        int ans = 0;
        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                // 해당 r,c 기준으로 테트로미노 블럭을 놓았을 때 가질 수 있는 합
                ans = Math.max(ans,currTetrominoSum(tr1, r, c));
                ans = Math.max(ans,currTetrominoSum(tr2Row, r, c));
                ans = Math.max(ans,currTetrominoSum(tr2Col, r, c));
                ans = Math.max(ans,currTetrominoSum(tr3Row, r, c));
                ans = Math.max(ans,currTetrominoSum(tr3Col, r, c));
                ans = Math.max(ans,currTetrominoSum(tr3RowRev, r, c));
                ans = Math.max(ans,currTetrominoSum(tr3ColRev, r, c));
                ans = Math.max(ans,currTetrominoSum(tr4Ang0, r, c));
                ans = Math.max(ans,currTetrominoSum(tr4Ang90, r, c));
                ans = Math.max(ans,currTetrominoSum(tr4Ang180, r, c));
                ans = Math.max(ans,currTetrominoSum(tr4Ang270, r, c));
                ans = Math.max(ans,currTetrominoSum(tr4Ang0Rev, r, c));
                ans = Math.max(ans,currTetrominoSum(tr4Ang90Rev, r, c));
                ans = Math.max(ans,currTetrominoSum(tr4Ang180Rev, r, c));
                ans = Math.max(ans,currTetrominoSum(tr4Ang270Rev, r, c));
                ans = Math.max(ans,currTetrominoSum(tr5Ang0, r, c));
                ans = Math.max(ans,currTetrominoSum(tr5Ang90, r, c));
                ans = Math.max(ans,currTetrominoSum(tr5Ang180, r, c));
                ans = Math.max(ans,currTetrominoSum(tr5Ang270, r, c));
            }
        }
        return ans;
    }

    private static int currTetrominoSum(int[][] tetromino, int r, int c) {
        int sum = map[r][c];
        for(int k=0; k<3; k++) {
            int nr = r+tetromino[k][0];
            int nc = c+tetromino[k][1];

            if(nr<0 || nc<0 || nr>=N || nc>=M) return 0;

            sum += map[nr][nc];
        }
        return sum;
    }
}
