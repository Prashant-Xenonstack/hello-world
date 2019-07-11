package dsutility;

public class LinkedList<T extends Comparable<T>> {
  
	Node<T> head;
	int size;
	
	public LinkedList() {
		head = null;
		size = 0;
	}

	public void insertFirst(T data) {
		Node<T> newNode = new Node<T>(data);
		if(head== null)
			head = newNode;
		else {
			newNode.setNext(newNode);
			head = newNode;
		}
		size++;
	}
	
	public void insertLast(T data) {
		Node<T> newNode = new Node<T>(data);
		if(head == null)
			head = newNode;
		else {
			Node<T> ptr;
			for(ptr = head; ptr.getNext()!=null;ptr=ptr.getNext());
			ptr.setNext(newNode);
		}
		size++;
	}
	
	public void insertPosition(T data, int position) {
		if(position < 0)
			insertFirst(data);
		else {
			Node<T> newNode = new Node<T>(data);
			Node<T> ptr;
			for(ptr = head;ptr.getNext()!= null && position>0;ptr=ptr.getNext(),position--);
			ptr.setNext(newNode);	
		}
	}
	
//	public void sortedInsert(T data) {
//		Node<T> newNode = new Node<T>(data);
//	}
	
}
