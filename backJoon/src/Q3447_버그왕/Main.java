package Q3447_버그왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String BUG = "BUG";
        try {
            while (true) {
                String str = br.readLine();
                while(str.contains(BUG)) {
                    str = str.replace(BUG, "");
                }
                sb.append(str).append("\n");
            }
        } catch (NullPointerException e) {
            br.close();
        }

        System.out.print(sb);
    }
}
