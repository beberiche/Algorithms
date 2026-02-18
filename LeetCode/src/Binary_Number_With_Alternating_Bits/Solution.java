package Binary_Number_With_Alternating_Bits;

class Solution {
    public boolean hasAlternatingBits(int n) {
        String str = binary(n);
        boolean check = alternatingBits(str);
        return check;
    }

    private String binary(int n) {
        StringBuilder sb = new StringBuilder();
        int num = n;

        while(num!=0) {
            int mod = num%2;
            num/=2;
            sb.append(mod);
        }
        return sb.reverse().toString();
    }

    private boolean alternatingBits(String str) {
        for(int i=1; i<str.length(); i++) {
            char prev= str.charAt(i-1);
            char curr= str.charAt(i);

            if(prev == curr) {
                return false;
            }
        }

        return true;
    }
}