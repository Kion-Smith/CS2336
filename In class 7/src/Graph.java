

public class Graph 
{
	public int[][] adj;
	public int vert;
	public int edge;
	
	public Graph(int v,int e,int a)
	{
		addEdge(v,e,a);
	}
	
	public void addEdge(int v,int e,int add)
	{
		adj[v][e] = add;
	}
}