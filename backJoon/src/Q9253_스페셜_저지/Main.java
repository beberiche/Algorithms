package Q9253_스페셜_저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str1, str2, p;
    static int[] table;
    private static void input() throws Exception{
        str1 = br.readLine();
        str2 = br.readLine();
        p = br.readLine();


    }

    private static boolean kmp(String str, String p) {
        int sLen = str.length();
        int pLen = p.length();
        int j=0;
        for(int i=0; i<sLen; i++) {
            while(j>0 && str.charAt(i) != p.charAt(j)) {
                j = table[j-1];
            }
            if(str.charAt(i) == p.charAt(j)) {
                if(j == pLen-1)
                    return true;
                else
                    j++;
            }
        }
        return false;
    }

    private static void makeTable(String p) {
        int size = p.length();
        table = new int[size];
        int j=0;
        for(int i=1; i<size; i++) {
            while(j>0 && p.charAt(i)!=p.charAt(j)) {
                j = table[j-1];
            }
            if(p.charAt(i)==p.charAt(j)) {
                table[i] = ++j;
            }
        }
    }

    private static void output() {
        if(kmp(str1,p) && kmp(str2, p)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }


    public static void main(String[] args) throws Exception{
        input();
        makeTable(p);
        output();
    }
}
