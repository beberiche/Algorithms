package Q4375_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            solve(sc.nextInt());
        }
    }

    private static void solve(int num) {
        int ans = 0;
        for(int i=1; ;i++) {
            ans = ((ans*10)+1)%num;
            if(ans==0) {
                System.out.println(i);
                break;
            }
        }
    }
}
