public class Twonumadd {
    private class ListNode {
        int val;
        ListNode next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int add = 0;
        while (l1 != null && l2 != null) {
            ListNode tmp = new ListNode();
            int sum = 0;
            if (l1 == null) {
                sum = l2.val + add;
                add = 0;
            } else if (l2 == null) {
                sum = l1.val + add;
                add = 0;
            } else {
                sum = l1.val + l2.val + add;
                add = 0;
            }
            tmp.val = sum % 10;
            add = sum / 10;
            cur.next = tmp;
            cur = tmp;
        }
        if (add == 0) {
            return dummy.next;
        } else {
            ListNode node = new ListNode();
            node.val = add;
            cur.next = node;
            return dummy.next;
        }
    }
}
