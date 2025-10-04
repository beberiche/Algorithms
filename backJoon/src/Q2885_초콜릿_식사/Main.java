package Q2885_초콜릿_식사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int total = (int) Math.pow(2, (int) Math.ceil(Math.log(K) / Math.log(2)));
        int size = total, cuts = 0, remain = K;
        while (remain > 0) {
            if (remain >= size) {
                remain -= size;
            } else {
                size >>= 1;
                cuts++;
            }
        }
        System.out.println(total + " " + cuts);
    }
}
