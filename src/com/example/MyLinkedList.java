package com.example;
/**
 * @author Duc Anh
 * Apr 7, 2018
 */
public class MyLinkedList {

	private Node head;

	private int size = 0;

	public static void main(String[] args) {
		MyLinkedList myList = new MyLinkedList();
		myList.append(2);
		myList.append(4);
		myList.append(9);
		myList.append(5);
		myList.append(10);
		myList.append(100);

		System.out.print("MyList: ");
		myList.printList();
		
		myList.removeTail(); 
		System.out.print("Remove Tail: ");
		myList.printList();

		System.out.print("Remove Item Greater Than 8: ");
		myList.removeGreaterThan(8);
		myList.printList();
	}

	// 1. append int to the last
	public void append(int i) {

		if (size == 0) {
			head = new Node(i);
			size++;
			return;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = new Node(i);
		size++;
	}

	// 2. remove last element
	public void removeTail(){
		Node temp = head;
		
		for (int i = 0; i < size - 2; i++) {
			temp = temp.next;
		}
		temp.next = null;
		
		size--;
	}

	// 3. remove all elements that is greater than value
	public void removeGreaterThan(int value){
		Node temp = head;
		
		int i = 0;
		while (i < size) {
			if (temp.data > value) {
				
				if (i == 0) {
					head = temp.next;
					temp = head;
				} else {
					temp = head;
					for (int j = 0; j < i - 1; j++) {
						temp = temp.next;
					}
					temp.next = temp.next.next;
					i--;
				}
				size--;
				
			} else {
				i++;
				temp = temp.next;
			}
		}

	}

	public void printList() {
		Node temp = head;
		for (int i = 0; i < size; i++) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	class Node {
		public Node next;
		public int data;

		public Node(int data) {
			this.data = data;
		}
	}

}
