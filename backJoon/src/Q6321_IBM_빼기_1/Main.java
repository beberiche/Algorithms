package Q6321_IBM_빼기_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            sb.append("String #").append(i).append("\n");
            for (int j = 0; j < str.length(); j++) {
                char answer = str.charAt(j);
                answer += 1;
                if (answer == 91) answer = 65;
                sb.append(answer);
            }
            sb.append('\n').append('\n');
        }
        System.out.print(sb);
    }
}
