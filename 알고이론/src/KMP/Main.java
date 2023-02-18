package KMP;

public class Main {
    static String parent, pattern;
    static int table[];
    public static void main(String[] args) {
        parent = "ABACAABCCAABACAABA";
        pattern = "AAAAAD";

        makeTable(pattern);

        search(parent, pattern);
    }

    private static void search(String str, String pattern) {
        int sLen = str.length();
        int pLen = pattern.length();

        int j=0;
        for(int i=0; i<sLen; i++) {
            while(j>0 && str.charAt(i) != pattern.charAt(j)) {
                j = table[j-1];;
            }

            if(str.charAt(i) == pattern.charAt(j)) {
                if(j == pLen-1) {
                    System.out.println(i-pLen+1+" "+ (i));
                    j = table[j];
                } else {
                    j++;
                }
            }
        }
    }

    private static void makeTable(String pattern) {
        int pLen = pattern.length();
        table = new int[pLen];

        int j=0;
        for(int i=1; i<pLen; i++) {
            while(j>0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j-1];
            }

            if(pattern.charAt(i)==pattern.charAt(j)) {
                table[i] = ++j;
            }
        }
    }
}
