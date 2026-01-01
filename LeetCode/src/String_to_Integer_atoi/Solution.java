package String_to_Integer_atoi;

class Solution {
    public int myAtoi(String s) {
        // 1. whitespace가 있으면제거한다. (앞부분만 한정)
        // 2. 음수인지 양수인지 확인한다. (idx가 0보다 크다면 음수가 와서는 안됨)
        // 3. 숫자가 맞는지 확인한다. 숫자가 아니라면 거기서 종료
        // 4. -2^31보다 작거나, 2^31-1보다 큰경우 반올림 처리

        String ss = s.trim();

        String sss = charFiltering(ss);

        int ans = range(sss);

        return ans;
    }

    String charFiltering(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(i==0 && ch =='+') {
                continue;
            }

            if((ch >= '0' && ch <= '9') || (i == 0 && ch == '-')) {
                sb.append(ch);
            } else {
                break;
            }
        }

        String ans = sb.toString();
        if(ans.isEmpty() || ans.equals("-")) {
            return "0";
        }

        return sb.toString();
    }

    int range(String s) {
        boolean negative = false;
        int i = 0;

        if (s.charAt(0) == '-') {
            negative = true;
            i = 1;
        }

        long acc = 0;

        for (; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') break;
            int digit = ch - '0';
            acc = acc * 10 + digit;

            if (!negative && acc > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (negative && acc > (long) Integer.MAX_VALUE + 1) {
                return Integer.MIN_VALUE;
            }
        }

        long val = negative ? -acc : acc;

        if (val > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (val < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) val;
    }
}