import java.util.Iterator;
import java.util.LinkedList;

public class BFS extends Graph {

	public int level[];

	public BFS(String filePath) throws Exception {
		readUnweightedGraph(filePath);
	}

	private void initialize() { // complete this method
		level = new int [numVertices];
		for(int i = 0; i<numVertices; i++) {
			level[i] = Integer.MAX_VALUE;
		}
	}

	private void traverse(int s) { // complete this method
		LinkedList<Integer>vertexQ = new LinkedList<Integer>();
		vertexQ.addLast(s);
		level[s] = 0;
		while(vertexQ.size()>0) {
			int v = vertexQ.removeFirst();
			LinkedList<Edge>row = adjList.get(v);
			Iterator<Edge>it = row.iterator();
			while(it.hasNext()) {
				Edge adjEdge = it.next();
				int w = adjEdge.dest;
				if(level[w] == Integer.MAX_VALUE) {
					level[w] = level[v]+1;
					vertexQ.addLast(w);
				}
			}
		}
	}

	public void execute(int s) { // complete this method
		initialize();
		traverse(s); 
	}

	public int countComponents() { // complete this method
		initialize();
		int j = 0;
		for(int i = 0; i<numVertices; i++) {
			if(level[i] == Integer.MAX_VALUE) {
				traverse(i);
				j++;
			}
		}
		return j;
	}

	public boolean[][] computeTransitiveClosure() { // complete this method
		boolean[][]M = new boolean[numVertices][];
		for(int i = 0; i<numVertices; i++) {
			M[i]= new boolean [numVertices];
			execute(i);
			for(int j = 0; j<numVertices; j++) {
				if(level[j]!=Integer.MAX_VALUE) {
					M[i][j] = true;
				}
				else {
					M[i][j]=false;
				}
			}
		}
		return M;
	}
}
