package Q3181_줄임말_만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Set<String> mz = new HashSet<>(Arrays.asList("i", "pa", "te",
                "ni", "niti", "a", "ali",  "nego", "no", "ili"));

        String[] arr = str.split(" ");
        String answer = "";

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i].charAt(0);

            if (i != 0 && mz.contains(arr[i])) {
                continue;
            }else {
                answer += ch;
            }
        }

        answer = answer.toUpperCase();

        sb.append(answer);
        System.out.println(sb.toString());
    }
}
