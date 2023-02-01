package com.koko.striver.day6;

public class reverseInSetOfK {
    public ListNode head;
    public static void main(String[] args) {
        reverseInSetOfK list1 = new reverseInSetOfK();
        reverseInSetOfK list2 = new reverseInSetOfK();

        list1.addToTheLast(new ListNode(1));
        list1.addToTheLast(new ListNode(2));
        list1.addToTheLast(new ListNode(3));
        list1.addToTheLast(new ListNode(4));
        list1.addToTheLast(new ListNode(5));
        list1.addToTheLast(new ListNode(6));
        list1.addToTheLast(new ListNode(7));
        list1.addToTheLast(new ListNode(8));
        System.out.println("list");
        list1.printList(list1.head);
        list1.head = list1.reverse(list1.head, 3);
        System.out.println();
        System.out.println("new List");
        list1.printList((list1.head));

    }

    private ListNode reverse(ListNode head, int k) {
        if(head== null) return null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        int count = 0;
        while (curr!=null && count<k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }


        /* next is now a pointer to (k+1)th node
           Recursively call for the list starting from
           current. And make rest of the list as next of
           first node */
        if (next != null)
            head.next = reverse(next, k);

        return prev;
    }


    private void printList(ListNode head) {
        while(head!=null) {
            if(head.next!= null) System.out.print(head.data + "->");
            else System.out.print(head.data);
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

