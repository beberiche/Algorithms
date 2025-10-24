package Q10707_수도요금;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        int X = A * P;
        int Y = 0;

        if (C >= P) {
            Y = B;
        } else {
            Y = B + ((P - C) * D);
        }
        
        System.out.println(Math.min(X, Y));
    }
}
