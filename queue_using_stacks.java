package queue;

import java.util.Scanner;
import java.util.Stack;

public class queue_using_stacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> primary= new Stack<>();
		Stack<Integer> secondary= new Stack<>();
		Scanner scan= new Scanner(System.in);
		int n= scan.nextInt();
		scan.close();
		input(primary,n);
		reverse_stack(primary, secondary,0);
		display_dequeue_order(primary);
		
		
	}
	public static void input(Stack<Integer>primary, int n) {
		for(int i=0; i<n;i++) {
			primary.push(i);
		}
	}
	
	public static void reverse_stack(Stack<Integer>primary,Stack<Integer>secondary, int index) {
		if(primary.isEmpty()) {
			return;
		}
		
		int item= primary.pop();
		reverse_stack(primary, secondary, index+1);
		secondary.push(item);
		if(index==0) {
			while(!secondary.isEmpty()) {
				primary.push(secondary.pop());
			}
		}
			
	}
	
	public static void display_dequeue_order(Stack<Integer>primary) {
		while(!primary.isEmpty()) {
			System.out.print(primary.pop()+" ");
		}
	}
}
