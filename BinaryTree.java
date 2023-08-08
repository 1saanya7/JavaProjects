package trees;

import java.util.Scanner;

public class BinaryTree {
	
	private class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data, Node left, Node right){
			this.data=data;
			this.left= left;
			this.right= right;
		}
		
		
		
		
	}
	private Node root;
	int size;
	BinaryTree(){
		Scanner s= new Scanner(System.in);
		this.root=takeInput(s, null,false);
	}
	private Node takeInput(Scanner s, Node parent, boolean a ) {
		if(parent==null) {
			System.out.println("Enter the data for the root node");
		}
		else {
			if(a) {
			System.out.println("Enter the data for left child of"+ " "+ parent.data);
		}
			
			else {
				System.out.println("Enter the data for right child of"+ " "+ parent.data);
			}
		}
		
		int node_data= s.nextInt();
		Node nn= new Node(node_data, null, null);
		size++;
		
		boolean choice= false;
		System.out.println("Do you have left child of"+ " "+ nn.data);
		choice= s.nextBoolean();
		if(choice) {
			nn.left= takeInput(s, nn, true);
		}
		
		choice= false;
		System.out.println("Do you have right child of"+ " "+ nn.data);
		choice= s.nextBoolean();
		if(choice) {
			nn.right= takeInput(s, nn, false);
		}
		
		return nn;
	}
}
