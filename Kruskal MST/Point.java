import java.io.*;
import java.util.*;

class Point {

	public ArrayList<Point> list = new ArrayList<Point>();
	public int node;
	public int tempVar = 0;
	
	public Point(int node) {
		this.node = node;
	}

	public void connect(Point node) {
		list.add(node);
	}

	public Point[] neighbors() {
		 Point[] arr = new Point[list.size()]; 
		return list.toArray(arr);
	}

	public String toString() {
		return node + " is connected to " + list.toString();
	}

	public boolean checkLoop(Point a) {
		if (this.tempVar == 1) {
			return false;
		}
		boolean abb = false;
		this.tempVar = 1;
		int i = 0;
		Point[] connectedPs = neighbors();
		int n = connectedPs.length;
		while(!abb && i < n) {
			Point arr = connectedPs[i];
				if (arr == a) {
					this.tempVar = 0;
					return true;
				}
				if (arr.tempVar == 0) {
					abb = arr.checkLoop(a);
				}
			i++;
		}
		this.tempVar = 0;
		return abb;
	}
}