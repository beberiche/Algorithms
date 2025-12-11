package Q5704_팬그램;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        while (true) {
            int[] a = new int[26];
            String str = sc.nextLine().replace(" ", "");
            if (str.equals("*"))
                break;
            for (int i = 0; i < str.length(); i++) {
                ++a[str.charAt(i) - 97];
            }
            String ret = "Y";
            for (int i = 0; i < a.length; i++) {
                if (a[i] == 0) {
                    ret = "N";
                    break;
                }
            }
            sb.append(ret).append("\n");
        }
        System.out.print(sb.toString());
        sc.close();
    }
}
