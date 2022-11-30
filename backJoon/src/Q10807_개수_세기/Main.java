package Q10807_개수_세기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        int num = sc.nextInt();
        int cnt = 0;
        for(int i=0; i<N; i++) {
            if(arr[i] == num) cnt++;
        }

        System.out.println(cnt);
    }
}
