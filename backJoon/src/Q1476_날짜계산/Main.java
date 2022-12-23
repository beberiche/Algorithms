package Q1476_날짜계산;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        br.close();
        int e,s,m,ans;
        e = s = m = ans = 1;
        while (true) {
            if(e==16) e=1;
            if(s==29) s=1;
            if(m==20) m=1;

            if(e==E && s==S && m==M) {
                bw.write(ans+"");
                break;
            }

            e++;
            s++;
            m++;
            ans++;
        }
        bw.flush();
        bw.close();

    }
}
