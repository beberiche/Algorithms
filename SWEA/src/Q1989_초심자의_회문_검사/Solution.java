package Q1989_초심자의_회문_검사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int TC = Integer.parseInt(br.readLine());
	for (int t = 1; t <= TC; t++) {
	    char[] arr = br.readLine().toCharArray();

	    boolean check = true;
	    for (int s = 0, e = arr.length - 1; s <= e; s++, e--) {
		if (arr[s] != arr[e]) {
		    check = false;
		    break;
		}
	    }
	    System.out.printf("#%d %d\n", t, check ? 1 : 0);
	}
    }
}
