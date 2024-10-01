import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MutantLanguage extends Graph {

	private String words[];
	private int numWords;
	private int inDegree[];

	public MutantLanguage(String filePath) throws FileNotFoundException {
		
	}

	private void readLanguage(String filePath) throws FileNotFoundException { // complete this method
		Scanner fileReader = new Scanner(new FileInputStream("x.txt"));
		numVertices = fileReader.nextInt();
		words = new String [numWords];
		for(int i = 0; i<numWords; i++) {
			words[i] = fileReader.next();
		}
		fileReader.close();
	}

	private void makeGraph() { // complete this method
		inDegree = new int[numVertices];
		adjList = new ArrayList<>(numVertices);
		for(int i = 0; i<numVertices; i++) {
			numVertices = 0;
			adjList.add(new LinkedList<Edge>());
		}
		for(int i = 0; i<numWords; i++) {
			String currentWord = null;
			String nextWord = null;
			words[i] = currentWord;
			words[i+1] = nextWord;
			int minLength = 0;
			if(currentWord.length()<nextWord.length()) {
				minLength = currentWord.length();
			}
			else {
				minLength = nextWord.length();
			}
			for(int j = 0; j<minLength; j++) {
				char x = currentWord.charAt(j);
				char y = nextWord.charAt(j);
				if(x!=y) {
					int src = x - 97;
					int dest = y - 97;
					Edge e = new Edge(src, dest);
					adjList.get(src).add(e);
					inDegree[dest] ++;
					break; 
				}
			}
		}

	}

	public char[] getOrder() throws Exception { // complete this method
		char [] topoOrder = new char [numVertices];
		LinkedList<Integer>vertexQ = new LinkedList<Integer>();
		int topoLevel = 0;
		for(int i = 0; i<numVertices; i++) {
			if(inDegree[i]==0) {
				vertexQ.addLast(i);
			}
		}
		while(vertexQ.size()>0) {
			int v = vertexQ.removeFirst();
			topoOrder[topoLevel] = (char)(v+97);
			topoLevel ++;
			LinkedList<Edge> row = adjList.get(v);
			Iterator<Edge>it = row.iterator();
			while(it.hasNext()) {
				Edge adjEdge = it.next();
				int w = adjEdge.dest;
				inDegree[w]--;
				if(inDegree[w]==0) {
					vertexQ.addLast(w);
				}


			}
			

		}
		if(topoLevel!=numVertices) {
			return null;
		}
		else {
			return topoOrder;
		}
	}
}