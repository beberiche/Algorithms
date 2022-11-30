package Q11653_소인수분해;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        while(N>1) {
            for(int i=2; i<=N; i++) {
                if(N%i==0) {
                    N/=i;
                    list.add(i);
                    break;
                }
            }
        }
        for(int i : list) {
            System.out.println(i);
        }
    }
}
