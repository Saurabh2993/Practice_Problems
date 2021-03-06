package graphsAndTrees;

public class Edge implements Comparable<Edge> {
	
	private int weight;
	private Vertex one, two; 
	
	public Edge(Vertex one, Vertex two) {
		this(one, two, 0);
	}

	public Edge(Vertex one, Vertex two, int weight) {
		this.one = one;
		this.two = two;
		this.weight = weight;
	}
	
	public Vertex getNeighbor(Vertex current) {
		if(!(current.equals(one) || current.equals(two))) {
			return null;
		}
		return(current.equals(one)) ? two : one;		
	}
	
	public Vertex getOne() {
		return this.one;
	}
	
	public Vertex getTwo() {
		return this.two;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge edge) {
		return this.weight - edge.weight;
	}
	
	public boolean equals(Object other) {
        if(!(other instanceof Edge)) {
            return false;
        }
        
        Edge e = (Edge) other;
        return e.one.equals(this.one) && e.two.equals(this.two);
	}

	

}