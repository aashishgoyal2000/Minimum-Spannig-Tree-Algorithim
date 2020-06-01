class Graph{
	public int[][] graph;
	public int[] availability;
	Graph(int[][] capacity) {
		graph = capacity;
		availability = new int[capacity.length];
		for (int i = 0; i < capacity.length; i++) {
			availability[i] = 0;
		}
	}

	public void neighbors(PriorityQueue pq, Point[] pArray, int index) {
	    set_node_value(pArray[index].node, -1);
	    for (int i = 0; i < graph.length; ++i) {
	      if (adjacent(pArray[index].node, i) && (get_node_value(i) == 0 || get_node_value(i) == 1)) {
	        set_node_value(i, 1);
	        pq.insert(pArray[i],
	                  pArray[index],
	                  get_edge_value(pArray[index].node, i));
	      }
	    }
  	}

	public void set_node_value(int u, int v) {
	    availability[u] = v;
	}

	public boolean adjacent(int x, int y) {
	    return graph[x][y] != 0;
	}

	public int get_node_value(int u) {
	    return availability[u];
	}

	public int get_edge_value(int x, int y) {
	    return graph[x][y];
	}

	public void set_edge_value(int x, int y, int v) {
	    graph[x][y] = v;
	}

	public String toString() {
	    String s = "";
	    for (int i = 0; i < 9; i++) {
	      for (int j = 0; j < 9; j++) {
	        s += graph[i][j] + " " + "\n";
	      }
	    }
	    return s;
	}

	public int numberOfNodes() {
	    return graph.length;
	}

	public int numberOfEdges() {
	    int count = 0;
	    for (int i = 0; i < 9; i++) {
	      for (int j = 0; j < 9; j++) {
	        if (graph[i][j] != 0) {
	          count++;
	        }
	      }
	    }
	    return count;
    }
}