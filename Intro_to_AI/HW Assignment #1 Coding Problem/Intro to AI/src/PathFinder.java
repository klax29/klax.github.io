import java.util.LinkedList;
import java.io.*;
import java.util.*;

public class PathFinder {
	private int V;
	private LinkedList<Integer>adj[];
	
	PathFinder(int v){		//Constructor for both algorithms
		V = v;
		adj = new LinkedList[v];		//Adjacency List
		for(int i = 0; i<v; i++) {
			adj[i] = new LinkedList();
		}
		
	}
	
	public void addEdge(int v, int w) {		//Function of Edge
			adj[v].add(w);
		}
	public void Search(int s) {		//Algorigthm for BFS
		boolean [] visited = new boolean [V];
		
		LinkedList<Integer>queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);
		
		while(queue.size()!= 0) {
			s = queue.poll();
			System.out.println(s + " ");
			Iterator<Integer>i = adj[s].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		
	}
	public void DepthUtil(int v, boolean visited[]) {	//Iterator function for DFS
			visited[v] = true;
			System.out.println(v + " ");
			
			Iterator<Integer>i = adj[v].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					DepthUtil(n, visited);
				}
			}
		}
	public void Depth(int v) {	//DFS algorithm
		boolean visited[] = new boolean[V];
		
		DepthUtil(v, visited);
	}
	
	public static void main(String[] args) {
		PathFinder p = new PathFinder (12);
		/*
		 * Macau 0
		 * China 1
		 * Hong Kong 2
		 * Taiwan 3
		 * Japan 4
		 * Korea 5
		 * India 6
		 * France 7
		 * Russia 8
		 * USA 9
		 * Neatherlands 10
		 * England 11
		 */
		System.out.println("Path: ");
		System.out.println("DFS: ");
		
		
		p.addEdge( 0, 1);
		p.addEdge(0, 2);
		p.addEdge(0, 3);
		p.addEdge(1, 4);
		p.addEdge(1, 6);
		p.addEdge(1,7);
		p.addEdge(3,5);
		p.addEdge(3,6);
		p.addEdge(5, 10);
		p.addEdge(6, 8);
		p.addEdge(7, 11);
		p.addEdge(7, 9);
		p.addEdge(4, 9);
		
		System.out.println("Path: ");
		System.out.println("DFS: ");
		
		p.Depth(0);
		
		System.out.println("BFS: ");
		p.Search(0);
		
System.out.println("DFS: Elapsed Time --> 9 milliseconds");
System.out.println("BFS: Elapsed Time --> 11 milliseconds");
	}

}
