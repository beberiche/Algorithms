package Q2581_소수;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for(int i=M; i<=N; i++) {
            for(int j=2; j<=i; j++) {
                if(i==j) list.add(i);
                if(i%j == 0) break;
            }
        }

        list.sort((a,b)->a-b);
        int ans = 0;
        for(int num : list) ans += num;

        if(list.size() <= 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
            System.out.println(list.get(0));
        }
    }
}
