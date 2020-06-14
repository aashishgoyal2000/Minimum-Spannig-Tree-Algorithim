class Graph{
	public int[][] graph;
	public int[][] temp;
	public int[] availability;
	Graph(int[][] capacity) {
		graph = capacity;
		temp = new int[capacity.length][capacity.length];
		availability = new int[capacity.length];
		for (int i = 0; i < capacity.length; i++) {
			availability[i] = 0;
		}
		for (int i = 0; i < capacity.length; i++) {
			for (int j = 0; j < capacity.length; j++) {
				temp[i][j] = 0;
			}
		}
	}

	void createPQ(PriorityQueue pq, Point[] pArray){
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				if (temp[i][j] == -1) {
					continue;
				}
				if (graph[i][j] != 0 && temp[i][j] == 0) {
					pq.add(pArray[i],pArray[j],get_edge_value(i,j));
				}
				temp[i][j] = -1;
				temp[j][i] = -1;
			}
		}	

	}

	public static boolean testMST(Point[] pArray) {
		int n = pArray.length;
		int[] tempArr = new int[n];
		for (int i = 0; i < n; i++) {
			tempArr[i] = 0;
		}
		tempArr[0] = 1;
		int count = 0;
		chechMST(pArray[0],tempArr);
		for (int i = 0;  i < n; i++) {
			if (tempArr[i] == 1)
				count++;
			else
				break;
		}
		if(count == n) 
			return true;
		else
			return false;
	}

	public static void chechMST(Point a, int[] tempArr) {
		Point[] connectedPs = a.neighbors();
		for (Point temp : connectedPs) {
			if(tempArr[temp.node] == 0) {
				tempArr[temp.node] = 1;
				chechMST(temp,tempArr);
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