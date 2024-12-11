package Q1526_가장_큰_금민수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = N; i >= 4; i--) {
            if (check(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean check(int num) {
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '4' && s.charAt(i) != '7') {
                return false;
            }
        }
        return true;
    }
}
