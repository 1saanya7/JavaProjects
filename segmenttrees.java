package segmenttrees;

public class segmenttrees {
	private class Node{
		int data;
		int starInterval;
		int endInterval;
		Node left;
		Node right;
		}
	Node root;
	public segmenttrees(int[]arr) {
		this.root=constructTree(arr,0,arr.length-1);
		}
	
	private Node constructTree(int[]arr, int si, int ei) {
		if(si==ei) {
				Node leafNode= new Node();
				leafNode.data= arr[si];
				leafNode.starInterval=si;
				leafNode.endInterval=ei;
				return leafNode;
		}
		
		Node node= new Node();
		node.starInterval=si;
		node.endInterval=ei;
		int mid=(si+ei)/2;
		node.left = this.constructTree(arr, si, mid);
		node.right=this.constructTree(arr, mid+1, ei);
		node.data=node.left.data + node.right.data;
		return node;
		
	}
	
	public void display() {
		this.display(this.root);
	}
	
	private void display(Node node) {
		String str="";
		if(node.left!=null) {
			str=str+"Interval = ["+ node.left.starInterval+","+ node.left.endInterval+"] Data = "+ node.left.data;
		}
		else {
			str= str+"No left child";
		}
		if(node.right!=null) {
			str=str+"Interval = ["+ node.right.starInterval+","+ node.right.endInterval+"] Data = "+ node.right.data;
		}
		else {
			str= str+"No right child";
		}
		
		System.out.println(str);
		if(node.left!=null) {
			this.display(node.left);
		}
		if(node.right!=null) {
			this.display(node.right);
		}
	}
	
	public int query(int qsi, int qei) {
		return this.query(this.root,qsi, qei);
	}
	
	private int query(Node node, int qsi, int qei) {
		if(node.starInterval> qsi && node.endInterval<qei) {
			return node.data;
			
		}
		
		else if(node.starInterval> qei|| node.endInterval<qsi) {
			return 0;
		}
		
		else {
			int leftans=this.query(node.left, qsi, qei);
			int rightans=this.query(node.right, qsi, qei);
			return leftans+rightans;
		}
	}
	
	public void update(int index, int newValue){
		this.root.data=this.update(this.root,index, newValue);
	}
	
	private int update(Node node, int index, int newValue) {
		if(index>=node.starInterval && index<=node.endInterval) {
			if(index==node.starInterval && index== node.endInterval) {
				node.data= newValue;
				
			}
			
			else {
				int leftvalue= this.update(node.left, index, newValue);
				int rightvalue= this.update(node.right, index, newValue);
				node.data= leftvalue+ rightvalue;
			}
		}
		
		else {
			return node.data;
		}
		
		return 0;
	}
}
