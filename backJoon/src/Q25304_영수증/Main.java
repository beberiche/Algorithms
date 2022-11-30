package Q25304_영수증;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int N = sc.nextInt();
        while(--N>=0) {
            num -= sc.nextInt() * sc.nextInt();
        }
        String ans = "";
        ans = num == 0 ? "Yes" : "No";

        System.out.println(ans);

    }
}
