package Add_Two_Numbers;

import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1.List화
        List<Integer> list1 = convertList(l1);
        List<Integer> list2 = convertList(l2);

        // 2.합 계산
        List<Integer> listSum = sum(list1, list2);

        ListNode answer = convertListNode(listSum, 0);

        // 3.ListNode화;
        return answer;
    }

    private ListNode convertListNode(List<Integer> listSum, int idx) {
        if (idx >= listSum.size()) {
            return null;
        }

        ListNode next = convertListNode(listSum, idx + 1);
        ListNode curr = new ListNode(listSum.get(idx));
        curr.next = next;
        return curr;
    }

    private List<Integer> sum(List<Integer> l1, List<Integer> l2) {
        int length = Math.max(l1.size(), l2.size());

        List<Integer> listSum = new ArrayList();
        boolean isOverTen = false;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            if (i < l1.size() && i < l2.size()) {
                sum = l1.get(i) + l2.get(i);
            } else if (i < l1.size()) {
                sum = l1.get(i);
            } else if (i < l2.size()) {
                sum = l2.get(i);
            }

            if (isOverTen) sum++;

            isOverTen = sum >= 10;
            listSum.add(isOverTen ? sum % 10 : sum);
        }
        if (isOverTen) {
            listSum.add(1);
        }
        return listSum;
    }

    private List<Integer> convertList(ListNode l) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = l;
        while (curr.next != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        list.add(curr.val);
        return list;
    }
}