package Q25192_인사성_밝은_곰곰이;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> s = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.equals("ENTER")) {
                cnt += s.size();
                s.clear();
            } else {
                s.add(str);
            }
        }

        if (!s.isEmpty()) {
            cnt += s.size();
        }
        System.out.println(cnt);
    }
}
