package recursions_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class small_dictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);
		String str= scan.next();
		scan.close();
		char [] help= str.toCharArray();
		Arrays.sort(help);
		String str1= String.valueOf(help);
		
		ArrayList<String> result= get_permutation(str1);
		
		result.sort(null);
		
		for(int j=0;j<result.size();j++) {
			String h= result.get(j);
			if(h.compareTo(str)>0) {
				System.out.println(h);
			}
		}
	
	}
	public static ArrayList<String>  get_permutation(String help){
		if(help.length()==0) {
			ArrayList<String>br= new ArrayList<>();
			
			br.add("");
			return br;
		}
		
		char ch= help.charAt(0);
		String ros= help.substring(1);
		ArrayList<String> rr= get_permutation(ros);
		ArrayList<String>mr= new ArrayList<>();
		for(String rrs: rr) {
			for(int i=0; i<=rrs.length();i++) {
				String val= rrs.substring(0,i)+ch+rrs.substring(i);
				
				mr.add(val);
			}
		}
		return mr;
	}
}
