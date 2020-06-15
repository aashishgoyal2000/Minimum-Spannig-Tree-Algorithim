#include<iostream>
#include<vector>
using namespace std;
const int N = 7;
class Point {
	public:
	int tempVar;
	int node;
	vector<int> v;
	void makeAnode(int node);
	void connect(Point pArray[], int node);
	bool checkExist(Point *a);
	void toString();
	bool connectToAll(Point pArray[]);
	int checkMST(Point pArray[], int tempArr[], int count);
	bool checkLoop(Point pArray[], int node, bool ab);
};
struct PriorityQueue {
	int nodeA[N*(N-1)];
	int nodeB[N*(N-1)];
	int edge_value[N*(N-1)];
}pq;
void sortPQ(int k);
Point arr[10];

int main(){
	for(int i = 0; i< N; i++) {
		arr[i].makeAnode(i);
	}
    int graph[N][N] = { 
    				{ 0, 2, 0, 3, 0, 0, 0 }, 
                    { 0, 0, 6, 0, 5, 5, 4 }, 
                    { 2, 6, 0, 2, 4, 0, 4 }, 
                    { 3, 0, 2, 0, 0, 0, 5 }, 
                    { 0, 5, 4, 0, 0, 3, 0 }, 
                    { 0, 5, 0, 0, 3, 0, 0 }, 
                    { 0, 4, 4, 5, 0, 0, 0 }
                       					  };
	int k = 0;
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			if (graph[i][j] != 0) {
				pq.nodeA[k] = i;
				pq.nodeB[k] = j;
				pq.edge_value[k] = graph[i][j];
				k++;
			}
		}
	}
	sortPQ(k);
	int ds = 0;
	int i = 0;
	while(!arr[0].connectToAll(arr) && i < k) {
		int a = pq.nodeA[i];
		int b = pq.nodeB[i];
		int edge_value = pq.edge_value[i];
		bool temp = false;
		if (arr[a].checkLoop(arr,b,temp))
		{
			i++;
			continue;
		}
		cout << a << " " << b << " " << edge_value << endl;
		arr[a].connect(arr,b);
		arr[b].connect(arr,a);
		ds += edge_value;
		i++;
	}
	cout << ds << endl;
	return 0;
}
bool Point::checkLoop(Point pArray[], int node, bool ab) {
	if (this->node == node)
	{
		return true;
	}
	vector<int> v = this->v;
	this->tempVar = 1;
	int i = 0;
	while (i < v.size() && !ab)
	{
		// cout << this->node << v[i] << endl;
		if (pArray[v[i]].tempVar == 0)
		{
			ab = pArray[v[i]].checkLoop(pArray,node,ab);
		}
		i++;
	}
	this->tempVar = 0;
	return ab;
}
int Point::checkMST(Point pArray[], int tempArr[], int count) {
	tempArr[this->node] = 1;
	count++;
	std::vector<int> v = this->v;
	for (int i = 0; i < v.size(); ++i)
	{
		if (tempArr[v[i]] == 0)
		{
			count = pArray[v[i]].checkMST(pArray,tempArr, count);
		}
	}
	return count;
}
bool Point::connectToAll(Point pArray[]) {
	int tempArr[N];
	for (int i = 0; i < N; ++i)
	{
		tempArr[i] = 0;
	}
	int count = 0;;
	int abb = checkMST(pArray, tempArr, count);
	if (abb == N)
	{
		return true;
	}
	for (int i = 0; i < N; ++i)
	{
		tempArr[i] = 0;
	}
	return false;
}
void sortPQ(int k) {
	for (int i = 0; i < k; ++i)
	{
		for (int j = i + 1; j < k; ++j)
		{
			if (pq.edge_value[i] > pq.edge_value[j])
			{
				int temp = pq.nodeA[i];
				pq.nodeA[i] = pq.nodeA[j];
				pq.nodeA[j] = temp;

				temp = pq.nodeB[i];
				pq.nodeB[i] = pq.nodeB[j];
				pq.nodeB[j] = temp;
				
				temp = pq.edge_value[i];
				pq.edge_value[i] = pq.edge_value[j];
				pq.edge_value[j] = temp;
			}
		}
	}
}
void Point::makeAnode(int node) {
	this->node = node;
	this->tempVar = 0;
}
void Point::connect(Point pArray[], int node) {
	bool res = checkExist(&pArray[node]);
	if (!res)
	{
		v.push_back(node);
		return;
	}
	return;
}
bool Point::checkExist(Point *a) {
	if ( this->node == a->node)
	{
		return true;
	}
	for (int i = 0; i < v.size(); ++i)
	{
		if (v[i] == a->node)
		{
			return true;
		}
	}
	return false;
}
void Point::toString() {
	for (int i = 0; i < v.size(); ++i)
	{
		cout << v[i] << " "; 
	}
	cout<<endl;
}