public class ReverseLinkedList_206 {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //递归
//    public ListNode reverseList(ListNode head) {
//        //特判
//        if(head==null){
//            return null;
//        }
//
//        //尾结点为新头结点
//        if (head.next == null ){
//            return head;
//        }
//
//        //非尾结点递归处理下一个节点，反转指向,并断开自己的next
//        ListNode newHead = reverseList(head.next);
//        head.next.next=head;
//        head.next=null;
//        return newHead;
//    }

    //迭代写法
    public ListNode reverseList(ListNode head) {
        // 定义前驱节点，初始为null
        ListNode prev = null;
        // 当前节点从头部开始
        ListNode curr = head;

        // 遍历链表直到当前节点为null
        while (curr != null) {
            // 保存当前节点的下一个节点
            ListNode nextTemp = curr.next;
            // 反转当前节点的指向，指向前驱节点
            curr.next = prev;
            // 前驱节点向后移动（当前节点成为新的前驱）
            prev = curr;
            // 当前节点向后移动（使用之前保存的next节点）
            curr = nextTemp;
        }

        // 遍历结束后，prev成为新的头节点
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

        ReverseLinkedList_206 solver = new ReverseLinkedList_206();
        ListNode newHead = solver.reverseList(n1);
        while (newHead != null) {
            System.out.print(newHead.val);
            System.out.print("->");
            newHead = newHead.next;
        }

    }

}
