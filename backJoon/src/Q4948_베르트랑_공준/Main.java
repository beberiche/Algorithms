package Q4948_베르트랑_공준;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int[] arr = new int[250000];

        for(int i=2; i<arr.length; i++) {
            arr[i] = i;
        }

        arr[1]= 1;
        for(int i=2; i<arr.length; i++) {
            for(int j=i+i; j<arr.length; j+=i) {
                if(j%i == 0) arr[j] = 0;
            }
        }


        while(true) {
            int N = sc.nextInt();
            if(N == 0) break;

            int cnt =0;
            for(int i=N+1; i<=2*N; i++) {
                if(arr[i] != 0) cnt++;
            }
            System.out.println(cnt);
        }
    }
}
