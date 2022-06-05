package Q4987_STL_String;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next();
		String B = sc.next();
		
		String ans = "";
		while(sc.hasNext()) {
			String str = sc.next();
			if(str.equals(A)) break;
			if(str.length() == 3 || str.indexOf(B) == 3) {
				ans += str;
			} 
		}
		System.out.println(ans);
		
	}
}
