package stacks;

public class stack_using_array {
	private int[]data;
	private int top;
	public static final int default_cap= 10;
	
	//default constructor
	public stack_using_array() throws Exception{
		this(default_cap);
		
		
	}
	//Parameterized constructor
	
	public stack_using_array(int capacity)throws Exception {
		if(capacity<=0) {
			throw new Exception("capacity irrelevant");
		}
		
		this.data= new int[capacity];
		this.top=-1;
	}
	
	public int size() {
		return (top+1);
	}
	
	public boolean is_empty() {
		return this.size()==0;
	}
	
	public void push(int val) throws Exception {
		if(this.size()==this.data.length) {
			throw new Exception("Stack is already full");
		}
		
		this.top++;
		this.data[this.top]=val;
	}
	
	public int pop() throws Exception {
		if(this.size()==0) {
			throw new Exception("Stack is empty");
		}
		
		int rv=this.data[this.top];
		this.data[this.top]=0;
		this.top--;
		return rv;

		}
	
	public int top() throws Exception{
		if(this.size()==0) {
			throw new Exception("Stack is empty");
		}
		int rv= this.data[this.top];
		return rv;
		
		
	}
	
	public void display() {
		for (int i=0; i< this.data.length;i++) {
			System.out.println(this.data[i]);
		}
	}
}
