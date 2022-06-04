package Q1181_문자_정렬_solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		List<String> arr= new ArrayList<>();
		
		for(int i=0; i<T; i++) {
			arr.add(sc.nextLine());
		}

		Set<String> setArr = new HashSet<>(arr);
		
		List<String> arr2 = new ArrayList<>(setArr);
		
		Collections.sort(arr2, (a,b ) -> a.compareTo(b));
		Collections.sort(arr2, (a,b) -> a.length() - b.length());

		for(int i=0; i<arr2.size(); i++) {
			System.out.println(arr2.get(i));
		}


	}
}
