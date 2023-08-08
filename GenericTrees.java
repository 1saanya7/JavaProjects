package trees;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTrees {
	
	private class Node{
		int data;
		ArrayList<Node> children;
		Node(int data){
			this.data= data;
			this.children= new ArrayList<>();
		}
	}
	
	private int size;
	private Node root; 
	
	GenericTrees(){
		Scanner s= new Scanner(System.in);
		this.root= take_input(s,null,0);
	}
	
	private Node take_input(Scanner s, Node parent, int ith_child) {
		if(parent==null) {
			System.out.println("Enter data for root node");
		}
		else {
			System.out.println("Enter the data for the"+ith_child+"th child of"+ parent.data);
		}
		
		int node_data= s.nextInt();
		Node node= new Node(node_data);
		this.size++;
		System.out.println("Enter the number of children for"+node_data);
		int children= s.nextInt();
		for(int i=0;i<children;i++) {
			Node child= this.take_input(s, node, i);
			node.children.add(child);
		}
		return node;
	}
	
	public void display() {
		this.display(this.root);
	}
	
	private void display(Node node) {
		String ans=node.data+"->";
		for(int i=0;i<node.children.size();i++) {
			ans= ans+ node.children.get(i).data+",";
		}
		ans= ans+"END";
		System.out.println(ans);
		for(int i=0;i<node.children.size();i++) {
			this.display(node.children.get(i));
		}
	}
}
