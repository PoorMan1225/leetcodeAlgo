package linked_list;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        MyDoubleLinkedList list = new MyDoubleLinkedList();
//        list.addAtHead(1);
//        list.addAtHead(2);
//        list.addAtHead(3);
//        list.printAllNode();

//        list.addAtTail(1);
//        list.addAtTail(2);
//        list.addAtTail(3);
//        list.printAllNodeReverse();

//        list.addAtHead(1);
//        list.addAtHead(2);
//        list.addAtHead(3);
//        list.addAtIndex(2, 7);
//        list.printAllNodeReverse();

        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.deleteAtIndex(1);
    }
}
