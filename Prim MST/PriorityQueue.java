class PriorityQueue {
	public Point[] arr;
	public int N = 0;
	PriorityQueue(int capacity){
		arr = new Point[capacity];
	}
	void insert(Point point, Point past, int distanceTravelled) {
		int b = contains(point.node);
		if (b == -1) {	
			point.makeANode(distanceTravelled,past);
			arr[N++] = point;
		}
		else if (b > distanceTravelled) {
			point.makeANode(distanceTravelled,past);
		}
		sort();
	}
	int contains(int node){
		for (int i = 0; i < N; i++) {
			if(arr[i].node == node) {
				return arr[i].distanceTravelled;
			}
		}
		return -1;
	}
	void sort(){
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if (arr[i].compareTo(arr[j]) > 0) {
					exch(i,j);
				}
			}
		}
	}
	void exch(int a,int b){
		Point temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public Point delMin() {
	    exch(0, N-1);
	    Point temp = arr[N-1];
	    N--;
	    sort();
	    return temp;
    }
    public int tellMin(){
    	return arr[0].node;
    }
    public String toString() {
	    String s = "";

	    for (int i = 0; i < N; ++i) {
	      s += arr[i].toString() + "\n";
	    }
	    return s;
    }
    boolean isEmpty(){
    	if (N==0) {
    		return true;
    	}
    	return false;
    }
}