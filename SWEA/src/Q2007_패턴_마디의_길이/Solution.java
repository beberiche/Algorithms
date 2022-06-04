package Q2007_패턴_마디의_길이;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
	System.setIn(new FileInputStream("./data/input2007.txt"));
	Scanner sc = new Scanner(System.in);
	int TC = sc.nextInt();

	for (int t = 1; t <= TC; t++) {
	    String str = sc.next();

	    for (int j = 1; j <= 10; j++) {
		if (str.substring(0, j).equals(str.substring(j, j + j))) {
		    System.out.println("#" + t + " " + j);
		    break;
		}
	    }
	}
    }
}
