package Q5032_탄산음료;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int[] arr = new int[str.length];

        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(str[i]);

        int sum = 0;
        int num = arr[0] + arr[1];
        while (num >= arr[2]) {
            sum += num / arr[2];
            num = num / arr[2] + num % arr[2];
        }
        System.out.println(sum);
    }
}
