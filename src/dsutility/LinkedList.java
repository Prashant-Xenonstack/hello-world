package dsutility;

public class LinkedList<T extends Comparable<T>> {
  
	GenericNode<T> head;
	int size;
	
	public LinkedList() {
		head = null;
		size = 0;
	}

	public void insertFirst(T data) {
		GenericNode<T> newNode = new GenericNode<T>(data);
		if(head== null)
			head = newNode;
		else {
			newNode.setNext(head);
			head = newNode;
		}
		size++;
	}
	
	public void insertLast(T data) {
		GenericNode<T> newNode = new GenericNode<T>(data);
		if(head == null)
			head = newNode;
		else {
			GenericNode<T> ptr;
			for(ptr = head; ptr.getNext()!=null;ptr=ptr.getNext());
			ptr.setNext(newNode);
		}
		size++;
	}
	
	public void insertPosition(T data, int position) {
		if(position <= 1)
			insertFirst(data);
		else {
			GenericNode<T> newNode = new GenericNode<T>(data);
			GenericNode<T> ptr,prev;
			for(ptr = head,prev = null;ptr!= null && position>1;prev = ptr,ptr=ptr.getNext(),position--);
			newNode.setNext(prev.getNext());
			prev.setNext(newNode);
		}
		size++;
	}
	
	public void sortedInsert(T data) {
		int p =1;
		for (GenericNode<T> ptr= head;ptr!=null && ptr.getData().compareTo(data)!= 1;ptr = ptr.getNext(),p++);
		insertPosition(data, p);
	}
	
	public int deleteFirst() {
		if(head == null)
			return 0;
		head = head.getNext();
		size--;
		return 1;
		
	}
	
	public int deleteLast() {
		if(head == null)
			return 0;
		GenericNode<T> ptr,prev;
		for(ptr = head,prev = null;ptr.getNext()!=null;prev =ptr,ptr=ptr.getNext());
		prev.setNext(null);
		size--;
		return 1;
	}
	
	public int deletePosition(int positon) {
		if(positon <= 1)
			return deleteFirst();
		GenericNode<T> ptr,prev;
		for(ptr = head,prev = null;ptr.getNext()!=null && positon > 1;prev =ptr,ptr=ptr.getNext(),positon--);
		prev.setNext(ptr.getNext());
		ptr.setNext(null);
		size--;
		return 1;
	}
	
	public T getNthDataFromLast(int n) {
		if(n > size)
			return null;
		GenericNode<T> forward,current;
		forward =current = head;
		for(int i=1;i<n;i++) {
			forward = forward.getNext();
		}
		for(;forward.getNext()!=null;current = current.getNext(),forward = forward.getNext());
		return current.getData();
	}
	
	public void createLoop(int position) {
		if(head== null)
			return ;
		GenericNode<T> ptr = head;
		for (ptr= head;position>1;ptr=ptr.getNext(),position--);
		//System.out.println(ptr.getData().toString());
		GenericNode<T> last = head;
		for (last= head;last.getNext()!=null;last=last.getNext());
		last.setNext(ptr);
		//System.out.print(last.getData().toString());
	}
	
	public boolean detectLoop() {
	if(head == null)
		return false;
	GenericNode<T> slow,fast;
	slow = fast = head;
	while(fast.getNext()!=null && fast.getNext().getNext()!=null) {
		fast= fast.getNext().getNext();
		slow = slow.getNext();
		if(slow.equals(fast))
			return true;
	}
	return false;
	}
	
	public void print() {
		if(head == null)
			return ;
		for(GenericNode<T> ptr = head; ptr!=null;ptr = ptr.getNext())
		{
		System.out.print(ptr.getData().toString()+ " ");	
		}
		System.out.println();
	}
	
}
