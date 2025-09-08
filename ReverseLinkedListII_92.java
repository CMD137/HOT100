public class ReverseLinkedListII_92 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public  static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // 1. prev 走到 left 前一位
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // 2. 切出子链表
        ListNode start = prev.next;           // left 节点
        ListNode end = start;
        for (int i = left; i < right; i++) {  // 找到 right 节点
            end = end.next;
        }
        ListNode next = end.next;             // right 后的节点
        end.next = null;                      // 断开

        // 3. 反转子链表
        prev.next = reverseList(start);       // 反转后的头接回去
        start.next = next;                    // 原 start 是反转后尾，接回后半段

        return dummy.next;
    }
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        ListNode newHead = reverseBetween(n1, 2, 4);
        while (newHead != null) {
            System.out.print(newHead.val);
            System.out.print("->");
            newHead = newHead.next;
        }
    }
}
