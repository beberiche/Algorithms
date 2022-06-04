package Q2941_크로아티아알파펫;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

	System.out.println(new Scanner(System.in).next().replaceAll("dz=", "#").replaceAll("z=", "#")
		.replaceAll("d-", "#").replaceAll("c=", "#").replaceAll("c-", "#").replaceAll("lj", "#")
		.replaceAll("nj", "#").replaceAll("s=", "#").length());
    }
}
