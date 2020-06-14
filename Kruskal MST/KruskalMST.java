class KruskalMST {
	public static void main(String[] args) {
			    // int[][] graph = { 
	    		// 		{ 0, 2, 0, 3, 0, 0, 0 }, 
       //                  { 0, 0, 6, 0, 5, 5, 4 }, 
       //                  { 2, 6, 0, 2, 4, 0, 4 }, 
       //                  { 3, 0, 2, 0, 0, 0, 5 }, 
       //                  { 0, 5, 4, 0, 0, 3, 0 }, 
       //                  { 0, 5, 0, 0, 3, 0, 0 }, 
       //                  { 0, 4, 4, 5, 0, 0, 0 }
       //                  					  };

		int[][] graph = {
						{0,4,0,0,0,0,0,8,0},
						{4,0,8,0,0,0,0,11,0},
						{0,8,0,7,0,4,0,0,2},
						{0,0,7,0,9,14,0,0,0},
						{0,0,0,9,10,0,0,0,0},
						{0,0,4,14,10,0,2,0,0},
						{0,0,0,0,0,2,0,1,6},
						{8,11,0,0,0,0,1,0,7},
						{0,0,2,0,0,0,6,7,0}
											};

	    // int[][] graph = { 
	    // 				{ 0, 7, 0, 5, 0, 0, 0 }, 
     //                    { 7, 0, 8, 9, 7, 0, 0 }, 
     //                    { 0, 8, 0, 0, 5, 0, 0 }, 
     //                    { 5, 9, 0, 0, 5, 6, 0 }, 
     //                    { 0, 7, 5, 5, 0, 8, 9 }, 
     //                    { 0, 0, 0, 6, 8, 0, 11 }, 
     //                    { 0, 0, 0, 0, 9, 11, 0 }
     //                    					  };
	    
		Graph gp = new Graph(graph);
		int n = graph.length;
	    PriorityQueue pq = new PriorityQueue();
	    Point[] pArray = new Point[n];

	    for (int i = 0; i < n; i++) {
	    	pArray[i] = new Point(i);
	    }
	    
	    gp.createPQ(pq,pArray);
	    // System.out.println(pq.toString());

	    int distanceTravelled = 0;

	    while(!Graph.testMST(pArray)) {
	    	PriorityQueue temp = pq.delMin();
	    	Point a  = temp.a;
	    	Point b  = temp.b;
	    	
	    	// if(a.node == 1 && b.node == 2){
	    	// 	System.out.println("Check Twice Entered");
	    	// 	a.checkTwiceLoop(b);
	    	// }

	    	if(a.checkLoop(b) == true) {
	    		continue;
	    	}
	    	System.out.println(a.node + " " + b.node + " " + temp.edge_value);
	    	a.connect(b);
	    	b.connect(a);
	    	distanceTravelled += temp.edge_value;
	    }


		System.out.println(Graph.testMST(pArray));
		System.out.println(distanceTravelled);


	}
}