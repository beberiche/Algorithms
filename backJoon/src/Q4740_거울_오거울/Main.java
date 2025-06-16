package Q4740_거울_오거울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main extends Exception {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final String END = "***";
        while (true) {
            String str = br.readLine();
            if (str.equals(END)) {
                break;
            } else {
                StringBuffer buf = new StringBuffer(str);
                String reverseStr = buf.reverse().toString();
                sb.append(reverseStr).append("\n");
            }
        }
        System.out.print(sb);
    }
}