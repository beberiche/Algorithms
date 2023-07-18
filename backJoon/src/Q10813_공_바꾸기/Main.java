package Q10813_공_바꾸기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int arr[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int tmp = arr[n1];
            arr[n1] = arr[n2];
            arr[n2] = tmp;
        }
        for(int i=1; i<=N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
