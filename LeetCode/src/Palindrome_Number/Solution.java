package Palindrome_Number;

public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        String str1 = sb.append(x).toString();
        String str2 = sb.reverse().toString();

        return str1.equals(str2);
    }
}
