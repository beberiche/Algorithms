package Q6500_랜덤_숫자_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;

            List<Integer> list = new ArrayList<>();
            list.add(n);
            n *= n;

            while (true) {
                String s = String.valueOf(n);
                while (s.length() < 8) {
                    s = "0" + s;
                }
                n = Integer.parseInt(s.substring(2, 6));

                if (list.contains(n))
                    break;

                list.add(n);
                n *= n;
            }

            sb.append(list.size()).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
