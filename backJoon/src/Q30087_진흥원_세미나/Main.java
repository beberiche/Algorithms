package Q30087_진흥원_세미나;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, String> m = new HashMap<>();

        m.put("Algorithm", "204");
        m.put("DataAnalysis", "207");
        m.put("ArtificialIntelligence", "302");
        m.put("CyberSecurity", "B101");
        m.put("Network", "303");
        m.put("Startup", "501");
        m.put("TestStrategy", "105");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String seminar = br.readLine();
            sb.append(m.get(seminar)).append("\n");
        }
        System.out.print(sb.toString());
    }
}
