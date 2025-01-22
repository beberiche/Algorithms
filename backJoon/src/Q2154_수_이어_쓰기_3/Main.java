package Q2154_수_이어_쓰기_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        for(int i=1; i<= 100000; i++) {
            sb.append(i);
        }
        System.out.println(sb.indexOf(str)+1);
    }
}
