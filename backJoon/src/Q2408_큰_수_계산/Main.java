package Q2408_큰_수_계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedList<Character> opList = new LinkedList<>();
        LinkedList<BigInteger> numList = new LinkedList<>();

        numList.push(new BigInteger(br.readLine()));
        for(int i = 0; i < N-1; i++) {
            char op = br.readLine().charAt(0);
            BigInteger num = new BigInteger(br.readLine());

            if(op == '+' || op == '-') {
                opList.add(op);
                numList.add(num);
            } else if(op== '*') {
                numList.add(numList.pollLast().multiply(num));
            } else {
                if(numList.getLast().compareTo(BigInteger.ZERO) != num.compareTo(BigInteger.ZERO)) {
                    numList.add(numList.pollLast().subtract(num.subtract(BigInteger.ONE)).divide(num));
                } else {
                    numList.add(numList.pollLast().divide(num));
                }
            }
        }

        BigInteger ret = numList.get(0);

        for(int i=0; i<opList.size(); i++) {
            if(opList.get(i) == '+') {
                ret = ret.add(numList.get(i+1));
            } else {
                ret = ret.subtract(numList.get(i+1));
            }
        }

        System.out.println(ret);
    }
}
