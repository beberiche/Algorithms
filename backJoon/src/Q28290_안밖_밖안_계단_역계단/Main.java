package Q28290_안밖_밖안_계단_역계단;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        Map<String, String> m = new HashMap<>();
        m.put("fdsajkl;", "in-out");
        m.put("jkl;fdsa", "in-out");
        m.put("asdf;lkj", "out-in");
        m.put(";lkjasdf", "out-in");
        m.put("asdfjkl;", "stairs");
        m.put(";lkjfdsa", "reverse");

        System.out.print(m.getOrDefault(br.readLine(), "molu"));
    }
}
