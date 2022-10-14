package Q14499_주사위_굴리기;

import java.util.Scanner;


public class Main {
    static final int[] DX = {0,0,-1,1};
    static final int[] DY = {1,-1,0,0};

    static int[] dice, newDice;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int K = sc.nextInt();

        int[][] map = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dice = new int[6];

        int dir;
        for(int i=0; i<K; i++) {
            dir = sc.nextInt()-1;
            int nextX = X+DX[dir];
            int nextY = Y+DY[dir];

            newDice = new int[6];
            if(nextX < 0 || nextX >= N || nextY<0 || nextY >= M) continue;

            copyDice();
            changeDice(dir);

            if(map[nextX][nextY] == 0) {
                map[nextX][nextY] = dice[5];
            } else {
                dice[5] = map[nextX][nextY];
                map[nextX][nextY] = 0;
            }
            System.out.println(dice[0]);
            X= nextX;
            Y= nextY;
        }
    }

    static private void copyDice() {
        for(int d=0; d<6; d++) newDice[d] = dice[d];
    }

    static private void changeDice(int dir) {
        switch (dir) {
            case 0: {
                dice[0] = newDice[3];
                dice[1] = newDice[1];
                dice[2] = newDice[0];
                dice[3] = newDice[5];
                dice[4] = newDice[4];
                dice[5] = newDice[2];
                break;
            }
            case 1: {
                dice[0] = newDice[2];
                dice[1] = newDice[1];
                dice[2] = newDice[5];
                dice[3] = newDice[0];
                dice[4] = newDice[4];
                dice[5] = newDice[3];
                break;
            }
            case 2: {
                dice[0] = newDice[1];
                dice[1] = newDice[5];
                dice[2] = newDice[2];
                dice[3] = newDice[3];
                dice[4] = newDice[0];
                dice[5] = newDice[4];
                break;
            }
            case 3: {
                dice[0] = newDice[4];
                dice[1] = newDice[0];
                dice[2] = newDice[2];
                dice[3] = newDice[3];
                dice[4] = newDice[5];
                dice[5] = newDice[1];
                break;
            }
        }
    }
}
