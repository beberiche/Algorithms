package Q10768_특별한_날;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());
        boolean isAfter = month >= 2 && day >= 18;
        boolean isSpecial = isAfter && month == 2 && day == 18;
        final String BEFORE = "Before";
        final String AFTER = "After";
        final String SPECIAL = "Special";
        System.out.println(isSpecial ? SPECIAL : isAfter ? AFTER : BEFORE);
    }
}
