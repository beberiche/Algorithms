package Q2023_신기한_소수;

import java.util.Scanner;

public class Main {

    static boolean[] prime = new boolean[10];

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        prime[2] = prime[3] = prime[5] = prime[7] = true;

        DFS("", 0);
        System.out.println(sb.toString());
    }

    private static void DFS(String str, int cnt) {
        if (cnt == N) {
            sb.append(str).append("\n");
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (cnt == 0 && !prime[i]) continue;
            if (checkPrime(str + i)) DFS(str + i, cnt + 1);
        }
    }

    private static boolean checkPrime(String strNum) {
        int tempNum = Integer.parseInt(strNum);
        for (int i = 2; i <= Math.sqrt(tempNum); i++) {
            if (tempNum % i == 0) return false;
        }
        return true;
    }
}
