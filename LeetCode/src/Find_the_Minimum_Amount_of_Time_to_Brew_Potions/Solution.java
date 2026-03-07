package Find_the_Minimum_Amount_of_Time_to_Brew_Potions;

public class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] prev = new long[n+1];

        calc(skill, mana, prev, 0);

        for(int i=1; i<m; i++) {
            long[] next = new long[n+1];
            calc(skill, mana, next, i);

            long max = 0;
            for(int j=0; j<n; j++) {
                long diff = prev[j+1] - next[j];
                max = Math.max(max, diff);
            }

            next[0] = max;
            for(int j=1; j<=n; j++) {
                next[j] += max;
            }
            prev = next;
        }

        return prev[n];
    }

    private void calc(int[] skill, int[] mana, long[] a, int manaIdx) {
        for(int j=1; j<a.length; j++) {
            a[j] = skill[j-1] * mana[manaIdx] + a[j-1];
        }
    }
}