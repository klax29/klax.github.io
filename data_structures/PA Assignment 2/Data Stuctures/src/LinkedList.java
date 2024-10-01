public class LinkedList {

	public ListNode head, tail;
	public int size;

	public LinkedList() {
		head = tail = null;
		size = 0;
	}

	public void insertAfter(ListNode argNode, int value) { // complete this method
		ListNode newNode = new ListNode(value);
		newNode.next = argNode.next;
		argNode.next = newNode;
		size++;
		if(tail == argNode) {
			tail = newNode;
		}

	}

	public void deleteAfter(ListNode argNode) { // complete this method
		if(tail == argNode) {
			System.out.println("Nothing to delete");
		}
		else if(tail == argNode.next) {
			tail.next = null;
			tail = argNode;
			size--;
		}
		else {
			ListNode tmp = argNode.next;
			argNode.next = tmp.next;
			tmp.next = null;
			size --;

		}
	}

	public void selectionSort() { // complete this method
		ListNode iNode = head;
		for (int i=0; i<size-1; i++) {
			ListNode minNode = iNode;
			ListNode jNode = iNode.next;
			for(int j = i+1; j<size; j++) {
				if(jNode.value<minNode.value) {
					minNode = jNode;
					jNode = jNode.next;
					
				}
				

			}
			int tmp = minNode.value;
			minNode.value = iNode.value;
			iNode.value = tmp;
			iNode = iNode.next;


		}
	}

	public boolean removeDuplicatesSorted() { // complete this method
		ListNode tmp = head;
		for(int i = 0; i<size-1; i++) {
			if(tmp.value > tmp.next.value) {
				return false;
			}
			else {
				tmp = tmp.next;
			}
		}
		ListNode current = head;
		while(current.next != null) { 
			if(current.value == current.next.value) {
				this.deleteAfter(current);
			}
			else {
				current = current.next;
			}
		}
		return true;

	}

	public void pushOddIndexesToTheBack() { // complete this method
		ListNode tmp = head;
		for(int i = 0; i<size-1; i+=2) {
			this.insertAtEnd(tmp.next.value);
			this.deleteAfter(tmp);
			tmp = tmp.next;
		}
	}

	public void reverse() { // complete this method
		ListNode curr = head.next;
		ListNode prev = head;

		while(curr!=null) {
			ListNode tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
		}
		ListNode tmp = head;
		head = tail;
		tail = tmp;
		tail.next = null; 
	}

	ListNode insertAtFront(int value) {
		ListNode newNode = new ListNode(value);
		if (size == 0) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
		return newNode;
	}

	ListNode insertAtEnd(int value) {
		ListNode newNode = new ListNode(value);
		if (size == 0) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
		return newNode;
	}

	void deleteHead() {
		if (0 == size) {
			System.out.println("Cannot delete from an empty list");
		} else if (1 == size) {
			head = tail = null;
			size--;
		} else {
			size--;
			ListNode tmp = head;
			head = head.next;
			tmp.next = null;
			tmp = null;
		}
	}

	public ListNode getNodeAt(int pos) {
		if (pos < 0 || pos >= size || 0 == size) {
			System.out.println("No such position exists");
			return null;
		} else {
			ListNode tmp = head;
			for (int i = 0; i < pos; i++)
				tmp = tmp.next;
			return tmp;
		}
	}

	void printList() {
		if (size == 0)
			System.out.println("[]");
		else {
			ListNode tmp = head;
			String output = "[";
			for (int i = 0; i < size - 1; i++) {
				output += tmp.value + " -> ";
				tmp = tmp.next;
			}
			output += tail.value + "]";
			System.out.println(output);
		}
	}

	public int getSize() {
		return size;
	}
}