package Q33937_태권도와_복싱을_합한_운동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        String sub1 = extract(str1);
        String sub2 = extract(str2);

        if (sub1 == null || sub2 == null) {
            System.out.println("no such exercise");
            return;
        }
        System.out.println(sub1 + sub2);
    }

    private static String extract(String str1) {
        boolean check = false;
        boolean success = false;
        StringBuilder sb = new StringBuilder();
        final String VOWELS = "aeiou";
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            boolean isVowel = VOWELS.indexOf(c) != -1;

            if (isVowel) {
                check = true;
            } else if (check) {
                success = true;
                break;
            }

            sb.append(c);
        }

        if (success) return sb.toString();
        return null;
    }
}
