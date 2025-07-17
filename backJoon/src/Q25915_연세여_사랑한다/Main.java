package Q25915_연세여_사랑한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Math.abs(br.readLine().charAt(0) - 'I') + 84);
    }
}
