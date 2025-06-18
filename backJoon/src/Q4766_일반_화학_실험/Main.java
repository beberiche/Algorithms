package Q4766_일반_화학_실험;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double N = Double.parseDouble(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(true) {
            double num = Double.parseDouble(br.readLine());
            if(num == 999) {
                break;
            }
            sb.append(String.format("%.2f", (num - N))).append("\n");
            N = num;
        }
        System.out.print(sb);
    }
}
