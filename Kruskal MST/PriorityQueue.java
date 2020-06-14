import java.io.*;
import java.util.*;

class PriorityQueue {

	public int N = 0;

	Point a;
	Point b;
	int edge_value;

	PriorityQueue curr = null;
	PriorityQueue next = null;
	PriorityQueue sortedInsert = null;

	public void add(Point a, Point b, int edge_value) { 
		N++;
		if (curr == null) {
			curr = new PriorityQueue();
			curr.a = a;
			curr.b = b;
			curr.edge_value = edge_value;
			next = curr;
		} 
		else if (next.edge_value <= edge_value) {
			next.next = new PriorityQueue();
			next = next.next;
			next.a = a;
			next.b = b;
			next.edge_value = edge_value;
		}
		else if (curr.edge_value > edge_value) {
			PriorityQueue temp2 = new PriorityQueue();
			temp2.a = a;
			temp2.b = b;
			temp2.edge_value = edge_value;
			temp2.next = curr;
			curr = temp2;
		}
		else {
			PriorityQueue temp = curr;
			PriorityQueue temp2 = null;
			while(temp.next != null) {
				if (temp.next.edge_value > edge_value) {
					temp2 = temp;
					break;
				}
				temp = temp.next;
			}
			PriorityQueue temp3 = temp2.next;
			temp2.next = new PriorityQueue();
			temp2 = temp2.next;
			temp2.a = a;
			temp2.b = b;
			temp2.edge_value = edge_value;
			temp2.next = temp3;
		} 
	}
	
	public String toString(){
		String s = "";
		PriorityQueue temp = curr;
		while (temp != null) {
			s += temp.a.node + " " + temp.b.node + " " + temp.edge_value + "\n";
			temp = temp.next;
			
		}
		return s;
	}
    
    boolean isEmpty(){
    	if (N==0) {
    		return true;
    	}
    	return false;
    }

	public PriorityQueue delMin() {
		PriorityQueue temp = curr;
		curr = curr.next;
		return temp;
	}

}