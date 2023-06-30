package Q14405_피카츄;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ans = br.readLine().replaceAll("chu", " ").replaceAll("ka", " ").replaceAll("pi", " ");
        System.out.println((ans.trim() == "" ? "YES" : "NO"));
    }
}
