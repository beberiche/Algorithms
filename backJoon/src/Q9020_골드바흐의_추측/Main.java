package Q9020_골드바흐의_추측;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] primeNumber= new int[10001];
        for(int i=0; i<primeNumber.length ;i++) {
            primeNumber[i] = i;
        }
        for(int i=2; i<primeNumber.length; i++) {
            if(primeNumber[i] != 0) {
                for (int j = i + i; j <primeNumber.length; j += i) {
                    if (j % i == 0) primeNumber[j] = 0;
                }
            }
        }
        while(--T>=0) {
            int num = sc.nextInt();

            List<Integer> arr = new ArrayList<>();
            for(int i=1; i<num; i++) arr.add(i);

            int cnt = 0;
            int mid = num/2-1;
            while(true) {
                int prev = primeNumber[arr.get(mid+cnt)];
                int next = primeNumber[arr.get(mid+cnt*-1)];
                if(prev != 0 && next != 0) {
                    String ans = prev >= next ? next + " " + prev : prev + " " + next;
                    System.out.println(ans);
                    break;
                } else cnt++;
            }
        }
    }
}
