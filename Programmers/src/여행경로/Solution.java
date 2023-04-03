package 여행경로;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    static Map<String, List<String>> psv = new HashMap<>();
    static List<String> ans;

    private static void input(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            List<String> currList = psv.get(tickets[i][0]);
            if (currList != null) {
                psv.get(tickets[i][0]).add(tickets[i][1]);
            } else {
                psv.put(tickets[i][0], new ArrayList<>());
                psv.get(tickets[i][0]).add(tickets[i][1]);
            }
        }
    }

    private static void updateAns(List<String> currList) {
        ans = new ArrayList<>();
        for (int i = 0; i < currList.size(); i++) ans.add(new String(currList.get(i)));
    }

    private static void check(List<String> currList) {
        outer:
        for (int i = 1; i < currList.size(); i++) {
            char[] ansStr = ans.get(i).toCharArray();
            char[] currStr = currList.get(i).toCharArray();
            for (int j = 0; j < 3; j++) {
                if (ansStr[j] != currStr[j]) {
                    if (currStr[j] < ansStr[j]) updateAns(currList);
                    break outer;
                }

            }
        }
    }

    private static void solve(int N, String name, List<String> currList) {
        if (currList.size() >= N + 1) {
            if (ans != null)
                check(currList);
            else
                updateAns(currList);

            return;
        }
        List<String> nextTickets = psv.get(name);
        if (nextTickets != null) {
            for (int i = 0; i < nextTickets.size(); i++) {
                String next = new String(nextTickets.get(i));
                if (next.length() <= 1) continue;
                nextTickets.set(i, "X");
                currList.add(next);
                solve(N, next, currList);
                currList.remove(currList.size() - 1);
                nextTickets.set(i, next);
            }
        }
    }

    private static String[] output(int N) {
        String[] temp = new String[N];
        for (int i = 0; i < N; i++) {
            temp[i] = ans.get(i);
        }
        return temp;
    }

    private static String[] solution(String[][] tickets) {
        input(tickets);
        List<String> tmp = new ArrayList<>();
        tmp.add("ICN");
        solve(tickets.length, "ICN", tmp);
        return output(tickets.length + 1);
    }

    public static void main(String[] args) {
//        solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
//        solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
        solution(new String[][]{{"ICN", "JFK"}, {"ICN", "AAD"}, {"JFK", "ICN"}});
    }
}
