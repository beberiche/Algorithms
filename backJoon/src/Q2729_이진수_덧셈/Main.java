package Q2729_이진수_덧셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String a1 = st.nextToken();
            String b1 = st.nextToken();

            BigInteger a2 = new BigInteger(a1, 2);
            BigInteger b2 = new BigInteger(b1, 2);

            BigInteger ans = a2.add(b2);
            sb.append(ans.toString(2)).append("\n");
        }

        System.out.print(sb.toString());

    }
}
