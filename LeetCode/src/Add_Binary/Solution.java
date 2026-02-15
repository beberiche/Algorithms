package Add_Binary;

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        // min, max
        String[] arr = check(a,b);
        boolean upper = false;

        for(int i=0; i<arr[1].length(); i++) {
            int c0 = 0;
            if(i < arr[0].length()) {
                c0 = arr[0].charAt(i) - '0';
            }
            int c1 = arr[1].charAt(i) - '0';

            int total = c0+c1;

            if(upper) {
                total++;
            }

            sb.append(total%2 == 0 ? 0 : 1);
            upper = total >=2;
        }

        if(upper) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }

    private String[] check(String a, String b) {
        if(a.length() > b.length()) {
            return new String[] {reverse(b), reverse(a)};
        }
        return new String[] {reverse(a),reverse(b)};
    }

    private String reverse(String str) {
        return new StringBuilder().append(str).reverse().toString();
    }
}
