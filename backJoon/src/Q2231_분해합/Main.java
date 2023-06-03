package Q2231_분해합;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int ans = 0;
        for(int i=1; i<=1000000; i++) {
            String str = String.valueOf(i);
            int sum = i;
            for(int j=0; j<str.length(); j++) {
                sum += str.charAt(j)-'0';
            }
            if(sum==N) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
