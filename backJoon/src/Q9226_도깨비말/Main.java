package Q9226_도깨비말;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s == null || s.equals("#")) break;

            int firstVowelIdx = -1;
            for (int i = 0; i < s.length(); i++) {
                if (isVowel(s.charAt(i))) {
                    firstVowelIdx = i;
                    break;
                }
            }

            if (firstVowelIdx <= 0) {
                // 모음으로 시작하거나 모음이 전혀 없는 경우
                sb.append(s).append("ay").append('\n');
            } else {
                // 처음 모음 이전의 자음군을 뒤로 보낸 후 ay
                sb.append(s.substring(firstVowelIdx))
                        .append(s, 0, firstVowelIdx)
                        .append("ay")
                        .append('\n');
            }
        }

        System.out.print(sb.toString());
    }

    private static boolean isVowel(char ch) {
        char c = Character.toLowerCase(ch);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
