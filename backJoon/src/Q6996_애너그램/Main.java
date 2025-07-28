package Q6996_애너그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] words = br.readLine().split(" ");
            String word1 = words[0];
            String word2 = words[1];


            sb.append(word1).append(" & ").append(word2).append(" are ")
                    .append(!isAnagram(word1, word2) ? "NOT " : "").append("anagrams.").append("\n");
        }
        System.out.print(sb);
    }

    private static boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] charCount = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            charCount[word1.charAt(i) - 'a']++;
            charCount[word2.charAt(i) - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
