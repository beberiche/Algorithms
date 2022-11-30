package Q2854_문제출제;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] fixNum = new int[100001];
        int[] varNum = new int[100001];

        // 0 : 고정 난이도의 문제를 내는 경우
        // 1 : 가변 난이도에서 i+1 단계로 문제를 내는 경우
        // 2 : 가변 난이도에서 i 단계로 문제를 내는 경우 (단 i+1 단계와 나타나는 중복개수는 제거해야한다.)
        long[][] DP = new long[100001][3];

        for(int i=1; i<=N; i++) fixNum[i] = sc.nextInt();
        for(int i=1; i<N; i++) varNum[i] = sc.nextInt();

        int div = (int) (1e9 + 7);
        DP[1][0] = fixNum[1];
        DP[1][1] = varNum[1];

        for(int i=2; i<=N; i++) {
            DP[i][0] = ((DP[i - 1][0] + DP[i - 1][1] + DP[i - 1][2]) * fixNum[i]) % div;
            DP[i][1] = ((DP[i - 1][0] + DP[i - 1][1] + DP[i - 1][2]) * varNum[i]) % div;
            DP[i][2] = ((DP[i - 1][0] + DP[i - 1][2]) * varNum[i - 1] + DP[i - 1][1] * (varNum[i - 1] - 1)) % div;
            System.out.println(DP[i][0] + " " + DP[i][1] + " " + DP[i][2]);
        }
        long ans = (DP[N][0]+ DP[N][1] + DP[N][2]) % div;
        System.out.println(ans);
    }
}