package graphsAndTrees;

import java.util.ArrayList;

public class Vertex {
	
	String label;
	ArrayList<Edge> neighbors;
	
//	Constructor for Vertex
	public Vertex(String label) {
		this.label = label;
		this.neighbors = new ArrayList<>();
	}
	
//	Function to add a new edge
	public void addNeighbor(Edge edge) {
		if(this.neighbors.contains(edge)) {
			return;
		}
		this.neighbors.add(edge);
	}
	
//	Check if the there is an edge connecting the vertices in 'edge'
	public boolean containsNeighbor(Edge edge) {
		return this.neighbors.contains(edge);
	}
	
//	get the neighbor at specified index
	public Edge getNeighbor(int index) {
		return this.neighbors.get(index);
	}
	
//	remove neighbor at specified index
	Edge removeNeighbor(int index) {
		return this.neighbors.remove(index);
	}
	
//	remove specified edge
	public void removeNeighbor(Edge e) {
		this.neighbors.remove(e);
	}
	
//	Get the number of adjacent vertices
	public int getNeighborCount() {
		return this.neighbors.size();
	}
	
//	get the label of current vertex
	public String getLabel() {
		return this.label;
	}
	
//	Get the list of neighbors
	public ArrayList<Edge> getNeighbors() {
		return new ArrayList<Edge> (this.neighbors);
	}

}
