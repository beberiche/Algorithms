package Q17427_약수의_합2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N+1];
        Arrays.fill(arr, 1);
        for(int i=2; i<=N; i++) {
            for(int j=i; j<=N; j+=i) {
                if(j%i == 0) arr[j]+=i;
            }
        }

        long sum = 0;
        for(long n : arr) sum+=n;
        System.out.println(sum-1);
    }
}
