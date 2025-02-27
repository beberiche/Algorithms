package Q2592_대표값;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int[] arr = new int[1001];
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            arr[num]++;
        }

        int index = 0;
        int max = 0;
        for (int i = 0; i < 1001; i++) {
            if (max < arr[i]) {
                max = arr[i];
                index = i;
            }
        }

        System.out.print((sum / 10) + "\n" + index);
    }
}
