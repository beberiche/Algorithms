package Q13909_창문_닫기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ret = (int) Math.sqrt(Double.parseDouble(br.readLine()));
        System.out.println(ret);
        br.close();
    }
}
