package Q5218_알파벳_거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCases; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            char[] word1 = stk.nextToken().toCharArray();
            char[] word2 = stk.nextToken().toCharArray();

            int[] distances = calculateDistances(word1, word2);
            sb.append("Distances: ");
            for (int distance : distances) {
                sb.append(distance).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static int[] calculateDistances(char[] word1, char[] word2) {
        int[] distances = new int[word1.length];

        for (int i = 0; i < word1.length; i++) {
            int distance = word2[i] - word1[i];
            if (distance < 0) {
                distance += 26;
            }
            distances[i] = distance;
        }
        return distances;
    }
}