package graphsAndTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Graph_Test {
	
	public static void main(String args[]) {
		
		Graph g = new Graph();
		Vertex v0 = new Vertex("0");
		g.addVertex(v0, false);
		Vertex v1 = new Vertex("1");
		g.addVertex(v1, false);
		Vertex v2 = new Vertex("2");
		g.addVertex(v2, false);
		Vertex v3 = new Vertex("3");
		g.addVertex(v3, false);
		Vertex v4 = new Vertex("4");
		g.addVertex(v4, false);
		Vertex v5 = new Vertex("5");
		g.addVertex(v5, false);
		
		g.addEdge(v0, v1);
		g.addEdge(v0, v4);
//		g.addEdge(v0, v5);
		
		g.addEdge(v1, v3);
		g.addEdge(v1, v4);
		
		g.addEdge(v2, v1);
		
		g.addEdge(v3, v2);
		g.addEdge(v3, v4);
		
		System.out.println(g.getRoute(v0, v5));
		
	}

}
