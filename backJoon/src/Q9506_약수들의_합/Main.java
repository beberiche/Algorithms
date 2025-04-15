package Q9506_약수들의_합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == -1) break;

            List<Integer> list = findDivisors(num);
            int sum = list.stream().reduce(0, Integer::sum);
            if (sum == num) {
                sb.append(num).append(" = ");
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));
                    if (i != list.size() - 1) {
                        sb.append(" + ");
                    }
                }
                sb.append("\n");
            } else {
                sb.append(num).append(" is NOT perfect.\n");
            }
        }
        System.out.print(sb);
    }

    private static List<Integer> findDivisors(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
