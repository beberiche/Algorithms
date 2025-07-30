package Q7567_그릇;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int h = 10;
        for (int i = 1; i < str.length(); i++) {
            h += (str.charAt(i) == str.charAt(i - 1)) ? 5 : 10;
        }
        System.out.print(h);
    }
}
