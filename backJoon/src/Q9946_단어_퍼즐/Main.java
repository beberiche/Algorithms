package Q9946_단어_퍼즐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNum = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            String original = br.readLine();
            String scrambled = br.readLine();

            if (original.equals("END") && scrambled.equals("END")) break;

            char[] arr1 = original.toCharArray();
            char[] arr2 = scrambled.toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);

            sb.append("Case ").append(caseNum++).append(": ");
            if (Arrays.equals(arr1, arr2)) {
                sb.append("same");
            } else {
                sb.append("different");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
