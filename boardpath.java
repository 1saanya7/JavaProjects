package recursions;

import java.util.ArrayList;
import java.util.Scanner;

public class boardpath {
 public static void main(String [] args) {
	 int curr, end;
	 Scanner scan= new Scanner(System.in);
	 curr= scan.nextInt();
	 end= scan.nextInt();
	 scan.close();
	 ArrayList<String>my_result= new ArrayList<String>();
	my_result =getboardpath(curr, end);
	 System.out.println(my_result.size());
 }
 public static ArrayList<String> getboardpath(int curr, int end){
	 if(curr==end) {
		 ArrayList<String> bc= new ArrayList<String>();
		 bc.add("");
		 return bc;
	 }
	 
	 if(curr>end) {
		 ArrayList<String> nbc= new ArrayList<String>();
		 return nbc;
	 }
	 
	 ArrayList<String> mr=  new ArrayList<String>();
	 for(int dice=1;dice<=6;dice++) {
		 ArrayList<String>rec_result= getboardpath(curr+dice, end);
		 for(String rrs: rec_result) {
			 mr.add(dice+rrs);
		 }
		 
	 }
	return mr; 
 }
}
