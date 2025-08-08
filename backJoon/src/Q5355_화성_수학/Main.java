package Q5355_화성_수학;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            String[] strs = str.split(" ");
            double answer = Double.parseDouble(strs[0]);
            for (int j = 1; j < strs.length; j++) {
                switch (strs[j]) {
                    case "@":
                        answer *= 3;
                        break;
                    case "%":
                        answer += 5;
                        break;
                    case "#":
                        answer -= 7;
                        break;
                    default:
                        break;
                }
            }
            sb.append(String.format("%.2f", answer)).append("\n");
        }
        System.out.print(sb.toString().trim());
    }
}
