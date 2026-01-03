package Complex_Number_Multiplication;

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        // (1+i)(1+i) = 1 + 2i + i^2 = 1 + 2i -1 = 0+2i
        // (1,-1i)(1,-1i) = 1 -2i - 1 = 0+-2i
        String[] a = num1.split("\\+");
        String[] b = num2.split("\\+");

        String c1 = a[0]; // 숫자
        String c2 = a[1].replace("i", ""); // i
        String c3 = b[0]; // 숫자
        String c4 = b[1].replace("i", ""); // i

        int cal1 = Integer.parseInt(c1) * Integer.parseInt(c3);
        int cal2 = Integer.parseInt(c2) * Integer.parseInt(c4) * -1;
        int cal3 = Integer.parseInt(c2) * Integer.parseInt(c3);
        int cal4 = Integer.parseInt(c1) * Integer.parseInt(c4);

        String aa = cal1 + cal2 + "";
        String bb = cal3 + cal4 + "";

        return aa + "+" + bb + "i";
    }
}