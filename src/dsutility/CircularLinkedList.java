package dsutility;

public class CircularLinkedList {

	Node trail;
	int size;

	public void insertFirst(int data) {
		Node newNode = new Node(data);
		if (trail == null) {
			trail = newNode;
			trail.setNext(trail);
		} else {
			newNode.setNext(trail.getNext());
			trail.setNext(newNode);
		}
		size++;
	}

	public void insertLast(int data) {
		Node newNode = new Node(data);
		if (trail == null) {
			trail = newNode;
			trail.setNext(trail);
		} else {
			newNode.setNext(trail.getNext());
			trail.setNext(newNode);
			trail = newNode;
		}
		size++;
	}

	public void insertPosition(int data, int position) {
		if (position <= 1)
			insertFirst(data);
		else if (position >= size)
			insertLast(data);
		else {
			Node ptr, prev;
			for (ptr = trail.getNext(), prev = null; ptr != trail
					&& position > 1; prev = ptr, ptr = ptr.getNext(), position--)
				;
			Node newNode = new Node(data);
			newNode.setNext(prev.getNext());
			prev.setNext(newNode);
			size++;
		}
	}

	public void printCircular() {
		Node ptr = trail.getNext();
		Node first = trail.getNext();
		do {
			System.out.print(ptr.getData() + " ");
			ptr = ptr.getNext();
		} while (ptr != first);
		System.out.println();
	}

	public int deleteFirst() {
		if (trail == null)
			return 0;
		else if (trail.getNext() == trail)
			trail = null;
		else
			trail.setNext(trail.getNext().getNext());
		size--;
		return 1;
	}

	public int deleteLast() {
		if (trail == null)
			return 0;
		else if (trail.getNext() == trail) {
			trail = null;
		} else {
			Node ptr;
			for (ptr = trail; ptr.getNext() != trail; ptr = ptr.getNext())
				;
			ptr.setNext(trail.getNext());
			trail = ptr;
		}
		size--;
		return 1;
	}

	public int deletePosition(int position) {
		if (position <= 1)
			return deleteFirst();
		else if (position >= size)
			return deleteLast();
		else {
			Node ptr, prev;
			for (ptr = trail.getNext(), prev = null; ptr != trail
					&& position > 1; prev = ptr, ptr = ptr.getNext(), position--)
				;
			prev.setNext(ptr.getNext());
			ptr.setNext(null);
			size--;
			return 1;
		}
		
	}
}
