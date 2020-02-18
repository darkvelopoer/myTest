package com.yyh.practice.algo;

public class ReverseListNode {

	static class Node {
		int n = 0;
		Node next;
		Node(int n){
			this.n = n;
			next = null;
		}
		
		/*static void next(Node node){
			Node.next(node);
		}
		static void prev(Node node){
			Node.prev(node);
		}*/
	}
	
	static Node head = null;
	//static Node next = null;
	//static Node prev = null;
	//static Node current = null;
	
	static Node reverse(Node node) {
		
		Node prev = null;
		Node current = node;
		Node next = null;
		
		while(current!=null) {
			next = current.next;
			current.next = prev;
			
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}
	
	static Node traverse(Node node) {

		int count = 0;
		int count2 = 0;
		node = push2(98);
		Node temp = node;
		while(node!=null) {
			
			node = node.next;
			count++;
		}
		node = temp;
		
		System.out.println("cnt::: " + count);
		int mod = count %2;
		int div = count / 2;
		
		System.out.println("mod::: " + mod);
		System.out.println("div::: " + div);
		
		int mid = 0;
		if(mod % 2 > 0) {
			mid = div + 1;
		}
		else {
			mid = div;
		}
		
		//Node tempNode = new Node(10);
		/*while(node!=null) {
			if(count2 == mid) {
				push(node, 98);
				break;
			}
			node = node.next;
			count2++;
		}*/
		
		//System.out.println("mid::: " + mid);
		//prev = node;
		//Node current = node.next;
		return node;
	}
	
	public static Node push(Node tmpNode, int n) {
		Node newNode = new Node(n);
		newNode.next= tmpNode;
		tmpNode = newNode;
		
		return tmpNode;
	}
	
	public static Node push2(int n) {
		Node newNode = new Node(n);
		newNode.next= head;
		head = newNode;
		
		return head;
	}
	
	public static void main (String[] args) {
		ReverseListNode rp = new ReverseListNode();
		rp.head = new Node(10);
		
		rp.head.next = new Node(20);
		rp.head.next.next = new Node(30);
		
		//head = rp.reverse(head);
		
		//head = rp.traverse(head);
		head = traverse(head); //rp.push(99);
		
		while(head != null) {
			System.out.println(head.n);
			head = head.next;
		}
		//Node currentNextNext = current.next(30);
		
		
	}
}
