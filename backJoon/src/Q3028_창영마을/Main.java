package Q3028_창영마을;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] cup = new boolean[3];
        String str = br.readLine();
        boolean temp;
        cup[0] = true;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'A':
                    temp = cup[0];
                    cup[0] = cup[1];
                    cup[1] = temp;
                    break;
                case 'B':
                    temp = cup[1];
                    cup[1] = cup[2];
                    cup[2] = temp;
                    break;
                case 'C':
                    temp = cup[0];
                    cup[0] = cup[2];
                    cup[2] = temp;
                    break;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (cup[i]) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
