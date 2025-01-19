package Q2139_나는_너가_살아온_날을_알고_있다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] mArr = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 };

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());

            int day = Integer.parseInt(stk.nextToken());
            int month = Integer.parseInt(stk.nextToken());
            int year = Integer.parseInt(stk.nextToken());

            if(day == 0 && month == 0 && year == 0) {
                break;
            }

            int totalDay = 0;
            boolean isLeapYear = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));

            if(isLeapYear && month > 2) {
                totalDay++;
            }

            for(int i = 0; i < month; i++) {
                totalDay += mArr[i];
            }

            totalDay += day;

            sb.append(totalDay).append("\n");
        }
        System.out.print(sb);
    }
}
