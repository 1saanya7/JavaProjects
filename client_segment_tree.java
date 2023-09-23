package segmenttrees;

import java.util.Scanner;

public class client_segment_tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
int arr[]= new int [6];
  for(int i=0; i<6;i++) {
	  arr[i]= scan.nextInt();
	  
  }
  scan.close();
  segmenttrees tree= new segmenttrees(arr);
  tree.display();
	}

}
