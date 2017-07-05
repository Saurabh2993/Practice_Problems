package graphsAndTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Graph_Test {
	
	static Graph g = new Graph();
	
	public static void main(String args[]) {
		
		Vertex v0 = new Vertex("a");
		g.addVertex(v0, false);
		Vertex v1 = new Vertex("b");
		g.addVertex(v1, false);
		Vertex v2 = new Vertex("c");
		g.addVertex(v2, false);
		Vertex v3 = new Vertex("d");
		g.addVertex(v3, false);
		Vertex v4 = new Vertex("e");
		g.addVertex(v4, false);
		Vertex v5 = new Vertex("f");
		g.addVertex(v5, false);
		Vertex v6 = new Vertex("g");
		g.addVertex(v6, false);
		
//		a -> e
		g.addEdge(v0, v4);
		
//		b -> a, b -> e
		g.addEdge(v1, v0);
		g.addEdge(v1, v4);
		
//		c -> a
		g.addEdge(v2, v0);
		
//		d -> g
		g.addEdge(v3, v6);
		
//		e -> b
//		g.addEdge(v4, v1);
		
//		f -> a, f -> b, f -> c
		g.addEdge(v5, v0);
		g.addEdge(v5, v1);
		g.addEdge(v5, v2);
		
		List<String> build_sequence = buildOrder();
		
		if(build_sequence == null) {
			System.out.println("Build not possible");
		} else {
			System.out.println(Arrays.asList(build_sequence));
		}
	}
	
	public static List<String> buildOrder() {
		
		List<String> build_sequence = new LinkedList<>();
		
		Queue<Vertex> independent_vertices = new LinkedList<>();
		List<Vertex> dependent_vertices = new ArrayList<>();
		
		Set<String> vertices = g.vertexKeys();
		Set<Edge> edges = g.getEdges();
		Set<Edge> edges_copy = new HashSet<>();
		
		for(Edge x : edges) {
			Vertex current = x.getTwo();
			if(!dependent_vertices.contains(current)) {
				dependent_vertices.add(current);
			}
		}
		
		if(dependent_vertices.size() == vertices.size()) {
			return null;
		}
		
		for(String x : vertices) {
			Vertex current = g.getVertex(x);
			if(!dependent_vertices.contains(current)) {
				independent_vertices.add(current);
				build_sequence.add(x);
			}
		}
		
//		System.out.println(dependent_vertices.size());
//		System.out.println(independent_vertices.size());
		
		while(dependent_vertices.size() != 0 && independent_vertices.size() != 0) {
			
			Vertex temp = independent_vertices.remove();
//			System.out.println("Current: " + temp.getLabel());
			
			edges_copy.clear();
			edges_copy.addAll(edges);
//			System.out.println("Removed Edges: ");
			for(Edge e : edges) {
				if(e.getOne().equals(temp)) {
//					System.out.println(e.getOne().getLabel() + " " + e.getTwo().getLabel());
					edges_copy.remove(e);
				}
			}
			edges.clear();
			edges.addAll(edges_copy);
			
			dependent_vertices = new ArrayList<>();
			
			for(Edge x : edges) {
				Vertex current = x.getTwo();
				if(!dependent_vertices.contains(current)) {
//					System.out.println(current.getLabel());
					dependent_vertices.add(current);
				}
			}
			
/*			System.out.println("Dependent Vertices");
			for(Vertex v : dependent_vertices) {
				System.out.print(v.getLabel() + " ");
			}
			System.out.println();*/
			
			for(String x : vertices) {
				Vertex current = g.getVertex(x);
				if(!dependent_vertices.contains(current) && !build_sequence.contains(x)) {
					independent_vertices.add(current);
					build_sequence.add(x);
				}
			}
			
	/*		System.out.println("Independent Vertices");
			for(Vertex v : independent_vertices) {
				System.out.print(v.getLabel() + " ");
			}
			System.out.println();*/
			
			
		}
		
		/*System.out.println("Build Sequence");
		for(String x : build_sequence) {
			System.out.print(x + " ");
		}*/
		
		if(build_sequence.size() != vertices.size()) {
			return null;
		} else {
			return build_sequence;
		}
	}

}
