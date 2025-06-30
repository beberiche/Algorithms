package Q5073_삼각형과_세_변;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];

        StringBuilder sb = new StringBuilder();
        while (true) {
            String answer = "Scalene";
            int maxValue = 0;
            int index = 0;
            for (int i = 0; i < 3; i++) {
                arr[i] = sc.nextInt();
                if (maxValue < arr[i]) {
                    index = i;
                    maxValue = arr[i];
                }

                int cnt = 0;
                for (int j = 0; j < i; j++) {
                    if (arr[i] == arr[j])
                        cnt++;
                }
                if (cnt == 1)
                    answer = "Isosceles";
                if (cnt == 2)
                    answer = "Equilateral";
            }
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;

            int sum = 0;
            for (int i = 0; i < 3; i++) {
                if (index != i)
                    sum += arr[i];
            }

            sb.append(sum > maxValue ? answer : "Invalid").append("\n");
        }
        System.out.print(sb);
    }
}