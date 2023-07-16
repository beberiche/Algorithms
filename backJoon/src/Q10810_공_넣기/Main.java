package Q10810_공_넣기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int arr[] = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int num = sc.nextInt();
            for (int j = st; j <= ed; j++) {
                arr[j] = num;
            }
        }

        for(int i=1; i<=N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
