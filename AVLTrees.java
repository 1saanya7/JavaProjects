package AVLTrees;

public class AVLTrees {
private class Node{
	int data;
	int height;
	Node left;
	Node right;
	
	Node(int item){
		this.data= item;
		this.height=0;
	}
}
	private Node root;
	public void insert(int item) {
		this.root= insert(this.root, item);
	}
	
	private Node insert(Node node, int item) {
		if(node==null) {
			Node nn= new Node(item);
			return nn;
		}
		
		if(item<node.data) {
			node.left= this.insert(node.left, item);
		}
		else if(item>node.data) {
			node.right= this.insert(node.right, item);
		}
		node.height= Math.max(height(node.left), height(node.right));
		int bf= bf(node);
		
		// rr case
		if(bf>1&&item<node.left.data) {
			return leftRotate(node);
		}
		
		// ll case
		if(bf<-1&&item>node.right.data) {
			return rightRotate(node);
		}
		
		// lr case
		if(bf>1&&item>node.left.data) {
			node.left= leftRotate(node.left);
			return rightRotate(node);
		}
		if(bf<-1&&item<node.right.data) {
			node.right= rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}
	
	public void display() {
		this.display(this.root);
	}
	
	private void display(Node node) {
		if(node==null) {
			return ;
		}
		
		String str="";
		if(node.left!=null) {
			str= str+node.left.data;
		}
		else {
			str= str+"left child does not exist";
		}
		
		str=str+" => "+ node.data+" <= ";
		
		if(node.right!=null) {
			str= str+node.right.data;
		}
		else {
			str= str+"right child does not exist";
		}
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
	private int height(Node node) {
		if(node==null) {
			return -1;
			
		}
		return node.height;
	}
	
	private Node rightRotate(Node node) {
		// get the required nodes
		Node b= node.left;
		Node T3=b.right;
		
		// rotating (c==node)
		b.right= node;
		node.left=T3;
		
		// updating height
		node.height= Math.max(height(node.left), height(node.right));
		b.height=Math.max(height(b.left), height(b.right));
		
		// return new root node
		return b;
	}
	// function to calculate balancing factor
	private int bf(Node node) {
	if(node== null) {
		return 0;
	}
	
	return (height(node.left)- height(node.right));
	}
	
	private Node leftRotate(Node node) {
		// get the required nodes
		Node b= node.right;
		Node T3=b.left;
		
		// rotating (c==node)
		b.left= node;
		node.right=T3;
		
		// updating height
		node.height= Math.max(height(node.left), height(node.right));
		b.height=Math.max(height(b.left), height(b.right));
		
		// return new root node
		return b;
}
}
