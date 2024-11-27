package LeetCode.Easy.LinkedLists;

public class Merge_Two_Sorted_Lists {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        ListNode temp = new ListNode();
        ListNode current = temp;


        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return temp.next;
    }
}
