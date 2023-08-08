package spacetimecomplexity;

import java.util.ArrayList;
import java.util.Scanner;

public class dutchflag {
	public static void main(String[] args) {
		int a,lo,mid,hi;
		Scanner scan = new Scanner(System.in);
		a=scan.nextInt();
		int [] arr= new int[a];
		for(int i=0;i<a;i++) {
			arr[i] =scan.nextInt();
			
		}
		scan.close();
		lo=0;
		mid=0;
		hi= arr.length-1;
		
		sort1(arr);
		sort2(arr,lo,mid,hi);
		for (int j=0; j<a;j++) {
			System.out.println(arr[j]);
		}
		
	}
	public static void sort1(int []arr) {
		int i=0;
		ArrayList<Integer> data= new ArrayList<>();
		for( i=0; i<arr.length; i++ ) {
			if(arr[i]==0) {
				data.add(i);
			}
		}
		for( i=0; i<arr.length; i++ ) {
			if(arr[i]==1) {
				data.add(i);
			}
		}
		for( i=0; i<arr.length; i++ ) {
			if(arr[i]==2) {
				data.add(i);
			}
		}
		int []arr1= arr.clone();
		
		
		for(i=0;i<arr.length;i++) {
			
			arr[i]= arr1[data.get(i)];
			
		}
		data.clear();
		
	}
	public static void sort2(int []arr, int lo, int mid, int hi) {
		
		while (mid<=hi) {
			if(arr[mid]==0) {
				swap(arr, lo,mid);
				lo++;
				mid++;
			}
			
			if(arr[mid]==1) {
				mid++;
			}
			
			if(arr[mid]==2) {
				swap(arr, mid,hi);
				mid++;
				hi--;			}
		}
	}
	
	private static void swap(int[]arr, int i, int j) {
		int temp= arr[i];
		arr[i]= arr[j];
		arr[j]= temp;
	}
	
}
