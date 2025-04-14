package Q2959_거북이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[4];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(nums);
        System.out.println(nums[0] * nums[2]);
    }
}
