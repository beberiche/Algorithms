package Q2153_소수_단어;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        char[] arr = br.readLine().toCharArray();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (Character.isLowerCase(arr[i])) {
                sum += arr[i] - 'a' + 1;
            } else { // 대문자일때
                sum += arr[i] - 'A' + 27;
            }
        }

        boolean check = true;
        for (int i = 2; i < sum; i++) {
            if (sum % i == 0) {
                check = false;
                break;
            }
        }

        sb.append("It is ").append(check ? "" : "not ").append("a prime word.");
        System.out.print(sb);
    }
}
