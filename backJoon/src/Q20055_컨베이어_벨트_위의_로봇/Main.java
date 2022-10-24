package Q20055_컨베이어_벨트_위의_로봇;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] cb;
    static boolean[] rb;
    static int step,zero;
    static int N,K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        cb = new int[2*N];
        rb = new boolean[2*N];

        for(int i=0; i<2*N; i++) cb[i] = sc.nextInt();

        step = 0;
        zero = 0;
        while(zero<K) {
            circle();
            nextCb();
            step++;
        }
        System.out.println(step);

    }
    private static void circle() {
        int tempC = cb[0];
        boolean tempR = rb[0];
        cb[0] = cb[2 * N - 1];
        rb[0] = rb[2 * N - 1];
        for (int i = 2 * N - 1; i > 1; i--) {
            cb[i] = cb[i - 1];
            rb[i] = rb[i - 1];
        }
        cb[1] = tempC;
        rb[1] = tempR;
    }
    private static void nextCb() {
        exitRobot();

        for(int i=N-2; i>0; i--) {
            // 현자리에 로봇이 없거나
            // 다음 앞길에 로봇이 있거나
            // 다음 가야하는 길이 내구도 0 이면 다 패스
            if(!rb[i] || cb[i+1]==0 || rb[i+1]) continue;
            rb[i] = false;
            rb[i+1] = true;
            checkZero(i+1);
        }

        if(cb[0]>0 && !rb[0]) {
            rb[0] = true;
            checkZero(0);
        }

        exitRobot();
    }

    // 0값이 되는지 확인하기
    private static void checkZero(int idx) {
        cb[idx]-=1;
        if(cb[idx]==0) zero++;
    }

    // 도착지점에 오면 바로 로봇이 나감
    private static void exitRobot() {
        if(rb[N-1]) rb[N-1] = false;
    }
}
