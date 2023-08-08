 package recursions;

import java.util.ArrayList;
import java.util.Scanner;

public class mazepath {
public static void main(String [] args) {
	int cr,cc,er,ec;
	Scanner scan= new Scanner(System.in);
	cr= scan.nextInt();
	cc= scan.nextInt();
	er= scan.nextInt();
	ec= scan.nextInt();
	scan.close();
	ArrayList<String>final_result= getmazepath(cr,cc,er,ec);
	System.out.println(final_result);
}
public static ArrayList<String> getmazepath(int cr,int cc,int er,int ec ){
	
	if(cr==er&&cc==ec) {
		ArrayList<String>base= new ArrayList<String>();
		base.add("");
		return base;
	}
	if(cr>er||cc>ec) {
		ArrayList<String>n_base= new ArrayList<String>();
		return n_base;
	}
	ArrayList<String>mr= new ArrayList<String>();
	ArrayList<String>rec_result_h= getmazepath(cr,cc+1,er,ec);
	for(String rrhs:rec_result_h) {
		mr.add("H"+ rrhs);
	}
	ArrayList<String>rec_result_v= getmazepath(cr+1,cc,er,ec);
	for(String rrvs:rec_result_v) {
		mr.add("v"+ rrvs);
	}
	return mr;
}

}
