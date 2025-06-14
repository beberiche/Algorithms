package Q4806_줄_세기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        while (true) {
            try {
                String str = sc.nextLine();
                cnt++;
            } catch (Exception e) {
                break;
            }
        }
        System.out.println(cnt);
    }
}