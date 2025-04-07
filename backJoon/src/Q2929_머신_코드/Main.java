package Q2929_머신_코드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        String regex = "([A-Z][a-z]*)";
        Pattern pattern = Pattern.compile(regex);
        int NOPcnt = 0, start;
        str = br.readLine();
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            start = matcher.start();
            start += NOPcnt;

            if (start % 4 != 0) {
                NOPcnt += 4 - start % 4;
            }
        }
        System.out.print(NOPcnt);
    }
}
