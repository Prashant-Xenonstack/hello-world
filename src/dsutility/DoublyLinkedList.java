package dsutility;

public class DoublyLinkedList {

	DNode head;
	DNode trail;
	int size;

	public class DNode {
		int data;
		DNode next;
		DNode prev;

		public DNode(int data) {
			super();
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public DNode getNext() {
			return next;
		}

		public void setNext(DNode next) {
			this.next = next;
		}

		public DNode getPrev() {
			return prev;
		}

		public void setPrev(DNode prev) {
			this.prev = prev;
		}
	}

	public void insertFirst(int data) {
		DNode newNode = new DNode(data);
		if (head == null) {
			head = newNode;
			trail = newNode;
		} else {
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;
		}
		size++;
	}

	public void insertLast(int data) {
		DNode newNode = new DNode(data);
		if (head == null) {
			head = newNode;
		} else {
			newNode.setPrev(trail);
			trail.setNext(newNode);
			trail = newNode;
		}
		size++;
	}

	public void insertPostion(int data, int postion) {
		if (postion <= 1)
			insertFirst(data);
		else if (postion >= size)
			insertLast(data);
		else {
			DNode newNode = new DNode(data);
			DNode ptr, prev;
			for (ptr = head, prev = null; ptr != null && postion > 1; prev = ptr, ptr = ptr.getNext(), postion--)
				;
			newNode.setNext(ptr);
			newNode.setPrev(prev);
			ptr.setPrev(newNode);
			prev.setNext(newNode);
		}
		size++;
	}

	public void print() {
		for (DNode ptr = head; ptr != null; ptr = ptr.getNext()) {
			System.out.print(ptr.getData() + " ");
		}
		System.out.println();
	}

	public void printReverse() {
		for (DNode ptr = trail; ptr != null; ptr = ptr.getPrev()) {
			System.out.print(ptr.getData() + " ");
		}
		System.out.println();
	}

	public int deleteFirst() {
		if (head == null)
			return 0;
		DNode temp = head;
		head = head.getNext();
		head.setPrev(null);
		temp.setNext(null);
		size--;
		return 1;
	}

	public int deleteLast() {
		if (head == null)
			return 0;
		DNode temp = trail;
		trail = trail.getPrev();
		trail.setNext(null);
		temp.setPrev(null);
		size--;
		return 1;
	}

	public int deletePosition(int position) {
		if(position <= 1)
			return deleteFirst();
		else if (position >= size)
			return deleteLast();
		else {
			DNode ptr,prev;
			for(ptr=head,prev= null;ptr.getNext()!=null && position>1;prev= ptr,ptr = ptr.getNext(),position--);
			prev.setNext(ptr.getNext());
			ptr.getNext().setPrev(prev);
			ptr.setNext(null);
			ptr.setPrev(null);
			size--;
			return 1;
		}
			
	}
}
