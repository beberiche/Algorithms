package Q9996_한국이_그리울_땐_서버에_접속하지;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String pattern = sc.next();

        StringBuilder sb = new StringBuilder();

        while(--N>=0) {
            int idx = pattern.indexOf("*");
            String prevPattern = pattern.substring(0, idx);
            String nextPattern = pattern.substring(idx+1, pattern.length());

            String currStr = sc.next();

            if((prevPattern+nextPattern).length() > currStr.length()) {
                sb.append("NE").append("\n");
                continue;
            }

            String prevStr = currStr.substring(0,prevPattern.length());
            String nextStr = currStr.substring(currStr.length()-nextPattern.length(), currStr.length());

            if(prevPattern.equals(prevStr)&& nextPattern.equals(nextStr)) {
                sb.append("DA").append("\n");
            } else {
                sb.append("NE").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
