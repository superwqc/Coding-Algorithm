package demo.interview;

/**
 * Created by Qi on 2017/9/16.
 */
class Node{
    int val;
    Node next;

    Node(int val){
        this.val=val;
    }
}

public class MergeLinkedList {
    /**
     * @Description  递归实现合并两个升序链表
     */
    public static Node listMerge(Node h1,Node h2){
        if (h1.next==null)
            return h2;
        if (h2.next==null)
            return h1;
        Node head=null;

        if (h1.val<h2.val){
            head=h1;
            head.next=listMerge(h1.next,h2);
        }
        else {
            head=h2;
            head.next=listMerge(h1,h2.next);
        }
        return head;
    }

    public static void main(String[] args) {
        //创建链表h1
        Node head1=null;
        Node n1=new Node(1);
        Node n3=new Node(3);
        Node n5=new Node(5);
        Node n7=new Node(7);
        head1=n1;
        n1.next=n3;
        n3.next=n5;
        n5.next=n7;
        n7.next=null;

        //创建链表h2
        Node head2=null;
        Node m2=new Node(2);
        Node m4=new Node(4);
        Node m6=new Node(6);
        head2=m2;
        m2.next=m4;
        m4.next=m6;
        m6.next=null;

        System.out.println(listMerge(head1,head2).toString());
    }
}
