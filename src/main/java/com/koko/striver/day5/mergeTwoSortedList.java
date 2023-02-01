package com.koko.striver.day5;

class ListNode{ // intentionally added outside otherwise static me 1-3-5-2-4-6 aa rha tha
    int data;
    ListNode next;

    ListNode() {
    }
    public ListNode(int d) {
        this.data = d;
        this.next = null;
    }
}
public class mergeTwoSortedList {
    public ListNode head;

    public static void main(String args[]) {
        mergeTwoSortedList list1 = new mergeTwoSortedList();
        mergeTwoSortedList list2 = new mergeTwoSortedList();


        list1.addToTheLast(new ListNode(1));
        list1.addToTheLast(new ListNode(3));
        list1.addToTheLast(new ListNode(5));
        System.out.println("Link List 1");
        list1.printList(list1.head);

        list2.addToTheLast(new ListNode(2));
        list2.addToTheLast(new ListNode(4));
        list2.addToTheLast(new ListNode(6));
        System.out.println("Link List 2");
        list2.printList(list2.head);

        list1.head = sortedMerge(list1.head, list2.head);
        System.out.println("");
        System.out.println("Merged LL");
        list1.printList(list1.head);
    }
    private static ListNode sortedMerge(ListNode headA, ListNode headB) {
            //        /* a dummy first node to
            //           hang the result on */
            //        ListNode dummyNode = new ListNode(0);
            //
            //        /* tail points to the
            //        last result node */
            //        ListNode tail = dummyNode;
            //        while (true) {
            //
            //            /* if either list runs out,
            //            use the other list */
            //            if (headA == null) {
            //                tail.next = headB;
            //                break;
            //            }
            //            if (headB == null) {
            //                tail.next = headA;
            //                break;
            //            }
            //
            //            /* Compare the data of the two
            //            lists whichever lists' data is
            //            smaller, append it into tail and
            //            advance the head to the next Node
            //            */
            //            if (headA.data <= headB.data) {
            //                tail.next = headA;
            //                headA = headA.next;
            //            }
            //            else {
            //                tail.next = headB;
            //                headB = headB.next;
            //            }
            //
            //            /* Advance the tail */
            //            tail = tail.next;
            //        }
            //        return dummyNode.next;

            // recursion easy hai

            if (headA == null) return headB;
            if (headB == null) return headA;
            if (headB.data > headA.data) {
                headA.next = sortedMerge(headA.next, headB);
                return headA;
            } else {
                headB.next = sortedMerge(headA, headB.next);
                return headB;
            }

        }
    private void printList(ListNode head) {
        while(head!=null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
    }
    private void addToTheLast(ListNode listNode) {
        if (head == null) {
            head = listNode;
        } else {
            ListNode temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = listNode;
        }
    }
}
