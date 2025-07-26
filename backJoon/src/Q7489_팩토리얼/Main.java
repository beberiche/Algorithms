package Q7489_팩토리얼;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            int target = sc.nextInt();
            int number = 1;

            for (int k = 2; k <= target; k++) {
                number *= k;

                while (number % 10 == 0) {
                    number /= 10;
                }
                number %= 100000;
            }

            sb.append(number % 10).append("\n");
        }
        System.out.print(sb);
    }
}