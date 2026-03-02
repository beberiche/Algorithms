package Find_Resultant_Array_After_Removing_Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> removeAnagrams(String[] words) {
        Map<String, String> m = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(String word : words) {
            list.add(word);
        }
        for(int i=1; i<list.size(); i++) {
            String ret1, ret2;
            String word1 = list.get(i-1);
            String word2 = list.get(i);
            if(m.containsKey(word1)) {
                ret1 = m.get(word1);
            } else {
                ret1 = counting(word1);
                m.put(word1, ret1);
            }

            if(m.containsKey(word2)) {
                ret2 = m.get(word2);
            } else {
                ret2 = counting(word2);
                m.put(word2, ret2);
            }

            if(ret1.equals(ret2)) {
                list.remove(i--);
            }
        }
        return list;
    }

    private String counting(String word) {
        int[] cntArr = new int[26];
        for(int i=0; i<word.length(); i++) {
            cntArr[word.charAt(i) - 'a']++;
        }
        return cntArrToString(cntArr);
    }

    private String cntArrToString(int[] arr) {
        char ch = 'a';
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++) {
            sb.append(ch++).append(":").append(arr[i]).append("/");
        }
        return sb.toString();
    }
}