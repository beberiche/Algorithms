package Q7513_준살_프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            sb.append("Scenario #").append(i + 1).append(":").append("\n");
            int wordCount = Integer.parseInt(br.readLine());
            String[] words = new String[wordCount];
            for (int j = 0; j < wordCount; j++) {
                words[j] = br.readLine();
            }
            int queryCount = Integer.parseInt(br.readLine());
            for (int j = 0; j < queryCount; j++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                int tokens = Integer.parseInt(stk.nextToken());
                for (int k = 0; k < tokens; k++) {
                    int index = Integer.parseInt(stk.nextToken());
                    sb.append(words[index]);
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        br.close();
        System.out.print(sb.toString());
    }
}
