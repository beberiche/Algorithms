package Q2587_대표값2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();
        while(true) {
            String curr =br.readLine();
            if(curr == null) break;
            else list.add(Integer.parseInt(curr));
        }
        list.sort((a,b)->a-b);
        int num = 0;
        for(int n: list) num+=n;


        System.out.println(num/list.size());
        System.out.println(list.get(list.size()/2));
    }
}
