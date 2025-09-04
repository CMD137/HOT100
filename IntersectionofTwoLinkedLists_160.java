import java.util.HashSet;

public class IntersectionofTwoLinkedLists_160 {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 使用HashSet
    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode tempA = headA;
        while (tempA != null) {
            set.add(tempA);
            tempA = tempA.next;
        }

        ListNode tempB = headB;
        while (tempB != null) {
            if (set.contains(tempB)) {
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;
    }*/

    // 双指针
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            // 如果走到末尾，就跳到另一个链表的头
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        // 相遇时要么是交点，要么都是null（没有交点）
        return pA;
    }

    public static void main(String[] args) {
        // 构造测试链表：
        // A: 1 -> 2 \
        //              8 -> 9
        // B:    3 -> 4/
        //
        // 交点在值为8的节点

        // 公共部分
        ListNode common1 = new ListNode(8);
        ListNode common2 = new ListNode(9);
        common1.next = common2;

        // 链表A
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        a1.next = a2;
        a2.next = common1; // 接入公共部分

        // 链表B
        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        b1.next = b2;
        b2.next = common1; // 接入公共部分

        IntersectionofTwoLinkedLists_160 solver = new IntersectionofTwoLinkedLists_160();
        ListNode intersection = solver.getIntersectionNode(a1, b1);

        if (intersection != null) {
            System.out.println("交点节点的值是: " + intersection.val);
        } else {
            System.out.println("没有交点");
        }
    }
}
