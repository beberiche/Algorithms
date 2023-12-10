package Q4779_칸토어_집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        StringBuilder sb= new StringBuilder();
        while ((str = br.readLine()) != null) {
            int num = Integer.parseInt(str);
            sb.append(recur((int) Math.pow(3, num))).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static StringBuilder recur(int len) {
        if (len <= 1) {
            return new StringBuilder("-");
        }


        StringBuilder bar = recur(len / 3);
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < len / 3; i++) {
            space.append(" ");
        }
        return new StringBuilder().append(bar).append(space).append(bar);
    }
}
