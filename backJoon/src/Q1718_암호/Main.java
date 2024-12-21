package Q1718_암호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Character> s = new ArrayList<>();
        List<Character> c = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentence = br.readLine();
        String code = br.readLine();

        for (int i = 0; i < sentence.length(); i++) {
            s.add(sentence.charAt(i));
        }
        for (int i = 0; i < code.length(); i++) {
            c.add(code.charAt(i));
        }
        int z = 0;
        char j = ' ';
        char[] cd = new char[sentence.length()];
        for (int i = 0; i < cd.length; i++) {
            cd[i] = s.get(i);
        }

        for (int i = 0; i < s.size(); i++) {
            if (s.size() > c.size()) {
                c.add(c.get(i));
            }
            z = c.get(i) - 'a' + 1;
            cd[i] = (char) (s.get(i) - z);
            if (cd[i] < 'a') cd[i] += 26;
            if (s.get(i) == ' ') cd[i] = ' ';
        }

        StringBuilder sb = new StringBuilder();
        for (char e : cd) sb.append(e);


        System.out.println(sb);
    }
}