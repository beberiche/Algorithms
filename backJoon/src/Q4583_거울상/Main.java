package Q4583_거울상;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        Set<Character> reflectSet = new HashSet<>(Arrays.asList('b', 'd', 'p', 'q', 'i', 'o', 'v', 'w', 'x'));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("#")) break;

            StringBuilder result = new StringBuilder();
            boolean isValid = true;

            for (char ch : str.toCharArray()) {
                if (!reflectSet.contains(ch)) {
                    isValid = false;
                    break;
                }
                switch (ch) {
                    case 'b':
                        result.append('d');
                        break;
                    case 'd':
                        result.append('b');
                        break;
                    case 'p':
                        result.append('q');
                        break;
                    case 'q':
                        result.append('p');
                        break;
                    default:
                        result.append(ch);
                        break;
                }
            }
            sb.append(isValid ? result.reverse() : "INVALID").append("\n");
        }
        System.out.print(sb);
    }
}