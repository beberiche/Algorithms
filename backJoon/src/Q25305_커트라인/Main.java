package Q25305_커트라인;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Integer[] arr = new Integer[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        Integer[] arr2 = new Integer[K];
        for(int i=0; i<K; i++) {
            arr2[i] = arr[i];
        }

        System.out.println(arr2[K-1]);
    }
}
