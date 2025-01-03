package Q1924_2007년;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int month = Integer.parseInt(stk.nextToken());
        int day = Integer.parseInt(stk.nextToken());

        LocalDate date = LocalDate.of(2017, month, day).plusDays(1);

        System.out.println(date.getDayOfWeek().toString().substring(0,3));
    }
}
