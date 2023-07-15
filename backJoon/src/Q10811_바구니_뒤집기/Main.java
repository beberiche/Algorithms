package Q10811_바구니_뒤집기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }


        for (int i = 0; i < M; i++) {
            int j = sc.nextInt();
            int k = sc.nextInt();

            for (int l = k, m = j; m < l; l--, m++) {
                int tmp = arr[l];
                arr[l] = arr[m];
                arr[m] = tmp;
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
