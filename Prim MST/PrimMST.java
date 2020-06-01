class PrimMST {
	public static void main(String[] args) {
	    int[][] graph = { 
	    				{ 0, 2, 0, 3, 0, 0, 0 }, 
                        { 0, 0, 6, 0, 5, 5, 4 }, 
                        { 2, 6, 0, 2, 4, 0, 4 }, 
                        { 3, 0, 2, 0, 0, 0, 5 }, 
                        { 0, 5, 4, 0, 0, 3, 0 }, 
                        { 0, 5, 0, 0, 3, 0, 0 }, 
                        { 0, 4, 4, 5, 0, 0, 0 }
                        					  };
	    Point pArray[] = new Point[graph.length];
	    for (int i = 0; i < graph.length; ++i) {
		    pArray[i] = new Point(i);
	    }
		Graph gp = new Graph(graph);
	    PriorityQueue pq = new PriorityQueue(graph.length);

	    System.out.println(pq.isEmpty());

	    System.out.println("Executing for Node 1");
	    gp.neighbors(pq,pArray,1);
	    System.out.println(pq.toString());

	    int ds = 0;

	    while(!pq.isEmpty()){
			ds += pq.arr[0].distanceTravelled;
		    System.out.println("Executing for Node " + pq.tellMin());
		    Point p = pq.delMin();
		    gp.neighbors(pq,pArray,p.node);
		    System.out.println(pq.toString());
	    }


	    System.out.println(ds);

	}
}