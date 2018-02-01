package cacheSystem;

public class Node {
	
	int item;
	int value;
	Node prev;
	Node next;
	
	
	Node(int item,int value) {
		this.item = item;
		this.value =value;
		prev=next =null;
	}

}
