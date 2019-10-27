package com.test.au;


//Java program to implement 
//a Singly Linked List 
public class LinkedList { 

	Node head; // head of list 

	// Linked list Node. 
	// This inner class is made static 
	// so that main() can access it 
	static class Node { 

		int data; 
		Node next; 
		
		
		// Constructor 
		Node(int d) 
		{ 
			data = d; 
			System.out.println("inside constructor....");
			next = null; 
		} 
	} 

	// Method to insert a new node 
	public static LinkedList insert(LinkedList list, int data) 
	{ 
		// Create a new node with given data 
		Node new_node = new Node(data); 
		new_node.next = null; 
		System.out.println("data is stored as - " + new_node.data);
		System.out.println("next is stored as - " + new_node.next);
		System.out.println("list.head is stored as - " + list.head);
		// If the Linked List is empty, 
		// then make the new node as head 
		if (list.head == null) { 
			list.head = new_node; 
			System.out.println("list.head is replaced with new node - " + new_node.data);
		} 
		else { 
			// Else traverse till the last node 
			// and insert the new_node there 
			Node last = list.head; 
			System.out.println("last is replaced as - " + last.data);
			
			while (last.next != null) { 
				last = last.next; 
				System.out.println("last value in while loop as - " + last.next);
			} 

			// Insert the new_node at last node 
			last.next = new_node; 
			System.out.println("last.next is replaced as - " + last.next);
		} 

		// Return the list by head 
		System.out.println("final return - " + list);
		return list; 
		
	} 

	// Method to print the LinkedList. 
	public static void printList(LinkedList list) 
	{ 
		Node currNode = list.head; 

		System.out.print("LinkedList: "); 

		// Traverse through the LinkedList 
		while (currNode != null) { 
			// Print the data at current node 
			System.out.print(currNode.data + " "); 

			// Go to next node 
			currNode = currNode.next; 
		} 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		/* Start with the empty list. */
		LinkedList list = new LinkedList(); 

		// 
		// ******INSERTION****** 
		// 

		// Insert the values 
		list = insert(list, 1); 
		list = insert(list, 2); 
		list = insert(list, 3); 
		list = insert(list, 4); 
		list = insert(list, 5); 
		list = insert(list, 6); 
		list = insert(list, 7); 
		list = insert(list, 8); 

		// Print the LinkedList 
		printList(list); 
	} 
} 

