package calling;

import dsutility.CircularLinkedList;
import dsutility.DoublyLinkedList;
import dsutility.LinkedList;

public class Calling {

	public static void main(String[] args) {
		
		//-----------region Singly Linked List-----------------------
		System.out.println("-----------region Singly Linked List-----------------------");
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.insertFirst(Integer.valueOf(7));
		l1.insertFirst(Integer.valueOf(6));
		l1.insertFirst(Integer.valueOf(5));
		
		l1.print();
		
		l1.insertLast(Integer.valueOf(8));
		l1.insertLast(Integer.valueOf(9));
		l1.insertLast(Integer.valueOf(10));
		l1.print();
		
		//System.out.println(Integer.valueOf(6).compareTo(Integer.valueOf(3)));
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.insertPosition(Integer.valueOf(6), 1);
		l2.insertPosition(Integer.valueOf(7), 1);
		l2.insertPosition(Integer.valueOf(8), 3);
		l2.insertPosition(Integer.valueOf(9), 3 );
		l2.insertPosition(Integer.valueOf(4), 1);
		l2.insertPosition(Integer.valueOf(3), 4);
		l2.insertPosition(Integer.valueOf(11), 2);
		
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		l3.sortedInsert(Integer.valueOf(6));
		l3.sortedInsert(Integer.valueOf(3));
		l3.sortedInsert(Integer.valueOf(5));
		l3.sortedInsert(Integer.valueOf(9));
		l3.sortedInsert(Integer.valueOf(15));
		l3.sortedInsert(Integer.valueOf(2));
		l3.sortedInsert(Integer.valueOf(7));
		l3.sortedInsert(Integer.valueOf(10));
		l3.sortedInsert(Integer.valueOf(1));
		l3.sortedInsert(Integer.valueOf(4));
		l3.sortedInsert(Integer.valueOf(8));
		l3.print();
		l3.deleteFirst();
		l3.deleteLast();
		l3.print();
		l3.deletePosition(3);
		l3.print();
		l3.deletePosition(9);
		l3.print();
		System.out.println(l3.getNthDataFromLast(3).toString());
		l3.createLoop(3);
		System.out.println(l3.detectLoop());
		System.out.println("----------------------end region--------------------------");
		//----------------------end region--------------------------
		
		//--------------------region Doubly Linked List--------------
		System.out.println("----------------------region Doubly Linked List--------------------------");
		DoublyLinkedList dl1 = new DoublyLinkedList();
		dl1.insertFirst(4);
		dl1.insertFirst(2);
		dl1.insertFirst(6);
		dl1.insertLast(7);
		dl1.insertLast(8);
		dl1.insertLast(9);
		dl1.print();
		dl1.insertPostion(1, 1);
		dl1.print();
		dl1.insertPostion(13, 5);
		dl1.print();
		dl1.insertPostion(12, 6);
		dl1.print();
		dl1.printReverse();
		dl1.deleteFirst();
		dl1.print();
		dl1.deleteLast();
		dl1.print();
		dl1.deletePosition(4);
		dl1.print();
		System.out.println("----------------------end region--------------------------");
		//--------------------end region-----------------------------
		
		//----------------Start region Circular LinkedList---------------------
		System.out.println("----------------------Start region Circular Link List--------------------------");
		CircularLinkedList clist = new CircularLinkedList();
		clist.insertFirst(4);
		clist.insertFirst(3);
		clist.insertFirst(6);
		clist.printCircular();
		clist.insertLast(12);
		clist.insertLast(8);
		clist.insertLast(9);
		clist.printCircular();
		clist.insertPosition(1, 1);
		clist.printCircular();
		clist.insertPosition(5, 4);
		clist.printCircular();
		clist.insertPosition(17, 8);
		clist.printCircular();
		System.out.println("Deleting Elements");
		clist.deleteFirst();
		clist.deleteLast();
		clist.printCircular();
		clist.deletePosition(1);
		clist.printCircular();
		clist.deletePosition(6);
		clist.printCircular();
		clist.deletePosition(4);
		clist.printCircular();
		System.out.println("----------------------end region--------------------------");
		//--------------------end region-----------------------------
	}

}
