package Q1926_간단한_369게임_replace_All;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	List<String> list = new ArrayList<>();

	for (int i = 0; i < n; i++) {
	    list.add(Integer.toString(i + 1));
	}

	StringBuilder ans = new StringBuilder();
	for (int j = 0; j < list.size(); j++) {
	    String str = list.get(j);
	    if (str.contains("3") || str.contains("6") || str.contains("9")) {
		str = str.replaceAll("[369]", "-");
		str = str.replaceAll("[1245780]", "");
	    }
	    ans.append(str + " ");
	}
	System.out.println(ans);
    }
}
