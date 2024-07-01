package Assignment;

import java.util.ArrayList;
import java.util.List;

//Graph Data Structure implementation
class Edge{
	private Product start;
	private Product end;
	private String type;
	
	//parameterized constructor
	public Edge(Product start, Product end, String type) {
		super();
		this.start = start;
		this.end = end;
		this.type = type;
	}
	
	//getters and setters
	public Product getStart() {
		return start;
	}
	public void setStart(Product start) {
		this.start = start;
	}
	public Product getEnd() {
		return end;
	}
	public void setEnd(Product end) {
		this.end = end;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Edge [start=" + start + ", end=" + end + ", type=" + type + "]";
	}	
}

class ProductGraph{
	private List<Product> products;
	private List<Edge> edges;
	
	//Default Constructor
	public ProductGraph() {
		this.products = new ArrayList<>();
		this.edges = new ArrayList<>();
	}
	//Getters
	public List<Product> getProducts() {
		return products;
	}

	public List<Edge> getEdges() {
		return edges;
	}
	public void addProduct(Product product){
		products.add(product);
	}
	
	public void addEdge(Product start,Product end,String type) {
		Edge edge = new Edge(start, end, type);
		edges.add(edge);
		//Assuming Graph is undirected,so we add edges in both directions
		edges.add(new Edge(end,start,type));
	}
	
	//check if product exists
	public boolean containsProduct(Product product){
		return products.contains(product);
	}
	
	//Get All edges connected to a specific product
	public List<Edge> getEdgesForProduct(Product product){
		List<Edge> result = new ArrayList<>();
		for(Edge edge : edges) {
			if(edge.getStart().equals(product)) {
				result.add(edge);
			}
		}
		return result;
	}
	@Override
	public String toString() {
		return "ProductGraph [products=" + products + ", edges=" + edges + "]";
	}	
}


public class Graph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductGraph graph = new ProductGraph();
		Product p1 = new Product("Laptop", 100000);
		Product p2 = new Product("Desktop", 50000);
		Product p3 = new Product("Tab", 25000);
		
		graph.addProduct(p1);
		graph.addProduct(p2);
		graph.addProduct(p3);
		
		graph.addEdge(p1, p2, "Type1");
		graph.addEdge(p2, p3, "Type2");
		
		System.out.println(graph);
		System.out.println("Edges for Product1: " + 
						graph.getEdgesForProduct(p1));
	}

}