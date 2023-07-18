package Q2444_별_찍기_7;

import java.util.Scanner;

public class Main {
    static int N;

    private static void go(int i) {
        String ret = "";
        for (int j = 0; j < N - i - 1; j++) {
            ret += " ";
        }
        for (int j = 0; j < i; j++) {
            ret += "*";
        }
        ret += "*";
        for (int j = 0; j < i; j++) {
            ret += "*";
        }
        System.out.println(ret);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            go(i);
        }
        for (int i = N - 2; i >= 0; i--) {
            go(i);
        }
    }
}
