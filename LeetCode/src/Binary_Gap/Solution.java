package Binary_Gap;

class Solution {
    public int binaryGap(int n) {
        // 1. binary로 변환
        // 2. st, ed 거리 계산

        String bin = toBinary(n);

        // 2-1. 첫 st 칮기
        int st = 0;
        int ed = 0;
        for(int i=0; i<bin.length(); i++) {
            if(bin.charAt(i) == '1') {
                st = i;
                break;
            }
        }

        int max = 0;
        for(int i=st+1; i<bin.length(); i++) {
            char ch = bin.charAt(i);
            if(ch == '1') {
                ed = i;
                max = Math.max(max, ed-st);
                st = ed;
            }
        }
        return max;
    }

    private String toBinary(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            int mod = n%2;
            sb.append(mod);
            n/=2;
        }
        return sb.reverse().toString();
    }
}
