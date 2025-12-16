package Reverse_Integer;

public class Solution {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x < 0 ? x * -1 : x);
        sb.reverse();

        try {
            int num = Integer.parseInt(sb.toString());
            return x < 0 ? num * -1 : num;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
