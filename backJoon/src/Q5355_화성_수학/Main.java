package Q5355_화성_수학;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < num; i++) {
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            double answer = -1;
            for (int j = 0; j < strs.length; j++) {
                if (j == 0) {
                    answer = Double.parseDouble(strs[0]);
                } else {
                    switch (strs[j]) {
                        case "@":
                            answer *= 3;
                            break;
                        case "%":
                            answer += 5;
                            break;
                        case "#":
                            answer -= 7;
                            break;
                        default:
                            break;
                    }
                }
                if (j == strs.length - 1)
                    System.out.printf("%.2f%n", answer);
            }
        }
    }
}
