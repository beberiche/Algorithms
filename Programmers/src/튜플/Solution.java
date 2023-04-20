package 튜플;

import java.util.*;

public class Solution {
    public static int[] solution(String s) {
        String rms = s.substring(2, s.length()-2);
        String[] srms = rms.split("},\\{");
        List<String> list[] = new ArrayList[srms.length];
        for(int i=0; i<list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<srms.length; i++) {
            for(String tt : srms[i].split(",")) {
                list[i].add(tt);
            }
        }
        Arrays.sort(list, (n1, n2)-> n1.size() - n2.size());
        int[] res = new int[100000+4];
        int[] answer = new int[list.length];
        for(int i=0; i<list.length; i++) {
            for(int j=0; j<list[i].size(); j++) {
                if(res[Integer.parseInt(list[i].get(j))] == 0) {
                    res[Integer.parseInt(list[i].get(j))]++;
                    answer[i] = Integer.parseInt(list[i].get(j));
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        solution("{{20,111},{111}}");
        solution("{{123}}");
        solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
    }
}
