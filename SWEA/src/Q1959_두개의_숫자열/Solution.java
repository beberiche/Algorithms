package Q1959_두개의_숫자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int TC = Integer.parseInt(br.readLine());

	for (int i = 1; i <= TC; i++) {
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int len1 = Integer.parseInt(st.nextToken());
	    int len2 = Integer.parseInt(st.nextToken());

	    int[] arr1 = new int[len1];
	    int[] arr2 = new int[len2];

	    st = new StringTokenizer(br.readLine());
	    for (int j = 0; j < len1; j++) {
		arr1[j] = Integer.parseInt(st.nextToken());
	    }

	    st = new StringTokenizer(br.readLine());
	    for (int j = 0; j < len2; j++) {
		arr2[j] = Integer.parseInt(st.nextToken());
	    }

	    if (arr1.length > arr2.length) {
		System.out.printf("#%d %d\n", i, twoLists(arr2, arr1));
	    } else {
		System.out.printf("#%d %d\n", i, twoLists(arr1, arr2));
	    }
	}

    }

    public static int twoLists(int[] arr1, int[] arr2) {
	int[] temp1 = new int[arr2.length];

	for (int i = 0; i < temp1.length; i++) {
	    if (arr1.length > i) {
		temp1[i] = arr1[i];
	    } else {
		break;
	    }
	}

	int max = 0;
	for (int i = 0; i < arr2.length - arr1.length + 1; i++) {

	    int sum = 0;
	    for (int j = 0; j < temp1.length; j++) {
		sum += temp1[j] * arr2[j];
	    }

	    if (sum > max) {
		max = sum;
	    }

	    // swap
	    int temp2 = temp1[temp1.length - 1];
	    for (int j = temp1.length - 1; j >= 1; j--) {
		temp1[j] = temp1[j - 1];
	    }
	    temp1[0] = temp2;
	}

	return max;
    }
}
