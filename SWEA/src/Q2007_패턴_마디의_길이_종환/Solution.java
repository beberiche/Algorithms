package Q2007_패턴_마디의_길이_종환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
	for (int test_case = 1; test_case <= T; test_case++) {

	    char[] arr = br.readLine().toCharArray();

	    int textLength = 1;
	    outer: for (int i = 0; i < 15; i++) {
		if (arr[i] != arr[i + textLength])
		    textLength++;
		else {
		    for (int j = 0; j < textLength; j++) {
			if (arr[j] != arr[textLength + j])
			    break;
			if (j == textLength)
			    break outer;
		    }
		}
	    }
	    System.out.printf("#%d %d\n", test_case, textLength);
	}
    }
}