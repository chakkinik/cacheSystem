package cacheSystem;

import java.util.HashMap;

public class LRUCache {

	
	// to implement we should have double linked list and hashtable to address
	// of each node pointing address of node
	
	int capacity;
	HashMap<Integer, Node>  map  = new HashMap<Integer, Node>();
	Node end;
	Node head;
	
	public LRUCache(int capacity){
		this.capacity=capacity;
	}
	
	public int  get(int item) {
		if(map.containsKey(item)){
			Node n =map.get(item);
			remove(n);
			setHead(n);
			return n.value;
		}
		return -1;
		
		}
	
	public void remove(Node n) {
	// if the node is not head 
		if(n.prev !=null) {
			n.prev=n.next;
		} else {
			head = n.next;
		}
	// if the previous node is tail
		
		if(n.next!=null) {
			n.next.prev = n.prev;
		} else {
			n.prev=null;
			end = n.prev;
		}
					
	}
	
	
	
	public void setHead(Node n) {
		//set the node to head 
		
		n.next=head;
		n.prev = null;
		
		// head is not null;
		if(head!=null) {
			head.prev=n;
			
		}
		head=n;
		if(end==null){
			end=head ;
		}
		
	}
	 
	public void set(int key, int value) {
		
		if(map.containsKey(key)){
			Node old = map.get(key);
			old.value=value;
			remove(old);
			setHead(old);
		} else {
			Node created = new Node(key ,value);
			// if the map has does not have capacity
			if(map.size() >= capacity){
				map.remove(end.item);
				remove(end);
				setHead(created);
			} else {
				setHead(created);
			}
			map.put(key, created);
						
		}
		
		
		
	}
	
	
	public static void main(String args[]){
		
		LRUCache cache = new LRUCache(16);
		cache.set(1,10);
		
		
		System.out.println(cache.get(1));
	}
	
	
}
