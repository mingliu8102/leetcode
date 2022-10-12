import java.util.HashMap;
import java.util.Map;

public class lc817 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int numComponents(ListNode head, int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            if (map.keySet().contains(cur.val)) {
                count++;
                while (map.keySet().contains(cur.val)) {
                    cur = cur.next;
                }
            } else {
                cur = cur.next;
            }

        }
        return count;
    }
}
