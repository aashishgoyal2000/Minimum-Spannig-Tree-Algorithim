import java.lang.Comparable;
class Point implements Comparable <Point>{
	public int node;
	public int distanceTravelled;
	public Point past;
	Point(int node){
		this.node = node;
	}
	public void makeANode(int distanceTravelled, Point past) {
		this.distanceTravelled = distanceTravelled;
		this.past = past;
	}
	public String toString() {
		String s = node+" "+distanceTravelled+" "+past.node;
		return s;
	}
	@Override
	public int compareTo(Point a){
		if (this.distanceTravelled > a.distanceTravelled) {
			return 1;
		}
		if (this.distanceTravelled < a.distanceTravelled) {
			return -1;
		}
		return 0;
	}
}