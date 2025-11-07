package Q9243_파일_완전_삭제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str1 = br.readLine();
        String str2 = br.readLine();

        boolean isSuccessful = true;

        if (N % 2 == 1) {
            for (int i = 0; i < str1.length(); i++) {
                char a = str1.charAt(i);
                char b = str2.charAt(i);

                if (a == b) {
                    isSuccessful = false;
                    break;
                }
            }
        } else {
            if (!str1.equals(str2)) {
                isSuccessful = false;
            }
        }

        if (isSuccessful) {
            System.out.println("Deletion succeeded");
        } else {
            System.out.println("Deletion failed");
        }
    }
}
