package Q15964_이상한_기호;

import java.util.Scanner;

public class Main {
    static Long A, B;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        A = sc.nextLong();
        B = sc.nextLong();
    }

    private static void output() {
        System.out.println((A+B)*(A-B));
    }

    public static void main(String[] args) throws Exception {
        input();
        output();
    }
}
