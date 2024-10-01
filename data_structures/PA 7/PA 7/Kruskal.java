import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Kruskal extends Graph {

	public Kruskal(String filePath) throws FileNotFoundException {
		super(filePath);
	}

	public ArrayList<Edge> runKruskal() { // complete this method
		ArrayList<ArrayList<Edge>> edgeList = adjList;
	
	
	UnionFind objUCF = new UnionFind(numVertices);
	ArrayList<Edge>n = new ArrayList<Edge>();
	int numEdgesAdded = 0;
	ArrayList<ArrayList<Edge>>e = edgeList;
	int source = 0;
	int dest = 0;
	int weight = 0;
	
	Edge m = new Edge(source, dest, weight);
	if(m.src != m.dest) {
		objUCF.doUnion(source, dest);
		n.add(e);
		numEdgesAdded ++;
		if(numEdgesAdded == (numVertices-1)) {
			break;
		}
	}
	return n;
	
	}

	

}